package libraries.dataStructures.linear;

/** Friendly class that represents a Node in a Generic LinkedList
 *  IT CONTAINS:
 *  - data, the element contained in the Node
 *  - next, the reference to the next Node in the LinkedList
 */

class LinkedNode<E> {

    E data;
    LinkedNode<E> next;
   
    /** Creates a Node that contains Element e, which is followed by Node next
     *  @param e Element contained in the Node
     *  @param next The node that follows this one
     */
    LinkedNode(E e, LinkedNode<E> next) {
        this.data = e;
        this.next = next;
    }
   
    /** Creates a Node that contains Element e, which is not followed by another node
     *  @param data Element that contains a Node
     */
    LinkedNode(E data) { this(data, null); }
}