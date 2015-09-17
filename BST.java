import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;

public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST
     */
    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Initializes the BST with the data in the Collection. The data in the BST
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element
     * in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Collection Data is null");
        }
        for (T element : data) {
            this.add(element);
        }
    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data element is null");
        }
        BSTNode<T> addNode = new BSTNode<T>(data);
        if (size == 0) {
            root = addNode;
        } else {
            BSTNode<T> prevNode = this.searchPreviousNode(root, data);
//            if (prevNode.getData().equals(data)) {
//                return;
            if (data.compareTo(prevNode.getData()) > 0) {
                prevNode.setRight(addNode);
            } else if (data.compareTo(prevNode.getData()) < 0) {
                prevNode.setLeft(addNode);
            }
        }
        size++;
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data element is null");
        }
        BSTNode<T> prevNode = this.searchPreviousNode(root, data);
        if (prevNode == null) {
            throw new NoSuchElementException(data + " not found");
        }
        if (prevNode.getLeft().getData().equals(data)) {
            BSTNode<T> replaceNode = prevNode.getLeft();
            if (replaceNode.getRight() == null && replaceNode.getLeft() == null) {
                prevNode.setLeft(null);
            } else if(replaceNode.getRight() != null && replaceNode.getLeft() != null) {
                prevNode.setLeft(replaceNode.getLeft());
                prevNode.getLeft().setRight(replaceNode.getRight());
            } else if (replaceNode.getRight() != null && replaceNode.getLeft() == null) {
                prevNode.setLeft(replaceNode.getRight());
            } else if (replaceNode.getLeft() != null && replaceNode.getRight() == null) {
                prevNode.setLeft(replaceNode.getLeft());
            } else {
                throw new NoSuchElementException(data + " not found");
            }
            size--;
            return replaceNode.getData();
        } else if (prevNode.getRight().getData().equals(data)) {
            BSTNode<T> replaceNode = prevNode.getRight();
            if (replaceNode.getRight() == null && replaceNode.getLeft() == null) {
                prevNode.setRight(null);
            } else if(replaceNode.getRight() != null && replaceNode.getLeft() != null) {
                prevNode.setRight(replaceNode.getLeft());
                prevNode.getRight().setRight(replaceNode.getRight());
            } else if (replaceNode.getRight() != null && replaceNode.getLeft() == null) {
                prevNode.setRight(replaceNode.getRight());
            } else if (replaceNode.getLeft() != null && replaceNode.getRight() == null) {
                prevNode.setRight(replaceNode.getLeft());
            } else {
                throw new NoSuchElementException(data + " not found");
            }
            size--;
            return replaceNode.getData();
        } else {
            throw new NoSuchElementException(data + " not found");
        }
    }

    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data element is null");
        }
        BSTNode<T> foundNode = this.searchNode(root, data);
        if (foundNode != null) {
            return foundNode.getData();
        } else {
            throw new NoSuchElementException(data + "not found");
        }
    }

    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data element is null");
        } else if (root == null) {
            return false;
        }
        return (this.searchNode(root, data) != null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public List<T> preorder() {
        return null;
    }

    @Override
    public List<T> postorder() {
        return null;
    }

    @Override
    public List<T> inorder() {
        return null;
    }

    @Override
    public List<T> levelorder() {
        Queue<BSTNode<T>> tempQueue = new LinkedList<BSTNode<T>>();
        List<T> returnList = new List<T>();
        tempQueue.add(root);
        while (tempQueue.size() != 0) {
            BSTNode<T> tempNode = tempQueue.remove();
        }
        return null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int height() {
        return findMaxHeight(root);
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        return root;
    }

    private BSTNode<T> searchNode(BSTNode<T> node, T data) {
        if (node == null || node.getData().equals(data)) {
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            return searchNode(node.getRight(), data);
        } else if (data.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), data);
        }
        return null;
    }

    private BSTNode<T> searchPreviousNode(BSTNode<T> node, T data) {
        if (node == null || node.getData().equals(data)) {
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRight() == null || node.getRight().getData().equals(data)) {
                return node;
            } else {
                return searchPreviousNode(node.getRight(), data);
            }
        } else if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null || node.getLeft().getData().equals(data)) {
                return node;
            } else {
                return searchPreviousNode(node.getLeft(), data);
            }
        }
        return null;
    }

    private int findMaxHeight(BSTNode<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findMaxHeight(node.getLeft());
        int rightHeight = findMaxHeight(node.getRight());

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}
