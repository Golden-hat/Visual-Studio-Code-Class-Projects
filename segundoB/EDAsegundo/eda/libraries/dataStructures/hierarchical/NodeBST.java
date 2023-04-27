package libraries.dataStructures.hierarchical;

 

/** NodeBST<E> friendly class: represents a Node of an BST, so
 * HAS A: 
 * 1.- E data, which represents the Element that occupies a Node of an BST 
 * 2.- NodeBST<E> left, a link to the Left Child of a Node of an BST
 * 3.- NodeBST<E> right, a link to the Right Child of a Node of an BST
 * 4.- size, an integer representing the size of a Node of an BST
 * An BST that has Nodes with this attribute is called BST with Rank
 *      
 * @param <E>, the type of BST data
 * @version April 2023
 */
class NodeBST<E> {
    // Attributes
    protected E data;
    protected int size;
    protected NodeBST<E> left;
    protected NodeBST<E> right;
     
    /** Constructor of a node without children
      * @param value Data to store in the node
      */
    public NodeBST(E value) {
        this(value, null, null);  
    }
     
    /** Constructor of a node with a given left and right child
      * @param value Data to store in the node
      * @param left Child of the node
      * @param right Right Child of the node
      */
    public NodeBST(E value, NodeBST<E> left, NodeBST<E> right) {
        data = value; 
        this.left = left;
        this.right = right;
        size = 1;
        if (left != null) { size += left.size; }
        if (right != null) { size += right.size; }
    }
}
