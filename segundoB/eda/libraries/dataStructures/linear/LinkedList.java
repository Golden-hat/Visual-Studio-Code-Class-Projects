package libraries.dataStructures.linear;

import libraries.dataStructures.models.List;

public class LinkedList<E> implements List<E> {

    // a LinkedList HAS A
    protected LinkedNode<E> first;
    // a LinkedList HAS A
    protected int size;
    
    /** creates an empty List with size 0 **/
    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    /** IFF 0<=i<=size():
     * inserts the element e in the position i of a List
     */
    public void add(E e, int i) {
        LinkedNode<E> node = new LinkedNode<E>(e);
        size++;
        LinkedNode<E> aux = first;
        LinkedNode<E> prev = null;
        for (int j = 0; j < i; j++) {
            prev = aux;
            aux = aux.next;
        }
        node.next = aux;
        if (prev == null) first = node;
        else prev.next = node;
    }

    /** IFF 0<=i<size():
     * removes the element that occupies position i in a List
     */
    public void remove(int i) {
        size--;
        LinkedNode<E> aux = first;
        LinkedNode<E> prev = null;
        for (int j = 0; j < i; j++) {
            prev = aux;
            aux = aux.next;
        }
        if (prev == null) first = aux.next;
        else prev.next = aux.next;
    }

    /** IFF 0<=i<size():
     * returns the element that occupies position i in a List
     */
    public E get(int i) {
        LinkedNode<E> aux;
        int j;
        for (aux = first, j = 0; j < i ; aux = aux.next, j++);
        return aux.data;
    }

    /** checks whether a List is empty **/
    public boolean isEmpty() {
        return first == null;
        //alternative: return size == 0;
    }
    
    /** returns the size of a list, or the amount of elements it contains **/
    public int size() { return this.size; }

    /** returns a String with the Elements of a List in insertion order,
     * and with the format used in the Java standard.
     * Thus, a List with Integer elements from 1 to 4 in insertion order,
     * toString returns [1, 2, 3, 4]; if the List is empty, returns []
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        if (size == 0) return res.append("]").toString();
        LinkedNode<E> aux = first;
        for (int i = 0, j = size - 1; i < j; i++, aux = aux.next)
            res.append(aux.data.toString() + ", ");
        res.append(aux.data.toString() + "]");
        return res.toString();
    }
}