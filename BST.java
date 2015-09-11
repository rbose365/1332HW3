import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST
     */
    public BST() {

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

    }

    @Override
    public void add(T data) {

    }

    @Override
    public T remove(T data) {

    }

    @Override
    public T get(T data) {

    }

    @Override
    public boolean contains(T data) {
        return (null != this.searchNode(root, data));
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public List<T> preorder() {

    }

    @Override
    public List<T> postorder() {

    }

    @Override
    public List<T> inorder() {

    }

    @Override
    public List<T> levelorder() {

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int height() {

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

    /**
    *
    */
    private BSTNode<T> searchNode(BSTNode<T> node, T data) {
        if (root.getData().equals(data) || node == null) {
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            return searchNode(node.getRight(), data);
        } else if (data.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), data);
        }
        return null;
    }

    private BSTNode<T> searchNextNode(BSTNode<T> node, T data) {
        if (root.getData().equals(data) || node == null) {
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            return searchNode(node.getRight(), data);
        } else if (data.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), data);
        }
        return null;
    }

}
