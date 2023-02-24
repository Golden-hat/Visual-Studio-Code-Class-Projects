package libraries.dataStructures.linear;
import libraries.dataStructures.models.*;

/** Implements the ListPOI through a generic LinkedList ...
 *  (a) With a fictitious Node as its header.
 *  (b) A reference to the first Node.
 *  (c) A reference to the last Node.
 *  (d) To represent the Point of Interest, a reference to
 *       the Node immediately before the POI.
 *  (e) An int size that represents the List's size.
 *
 * @version February 2019
 * @param <E> data type of the structure's elements
 */
public class LinkedListPOI<E> implements ListPOI<E> {

    protected LinkedNode<E> first, prev, last;
    protected int size;

    /** creates an empty LinkedList with POI **/
    public LinkedListPOI() {
        first = last = prev = new LinkedNode<E>(null);
        size = 0;
    }
    
    /** adds e to a List before the Element at its POI,
     * which remains unaltered.
     *
     * @param e Element to be added.
     **/
    public void add(E e) {
        LinkedNode<E> node = new LinkedNode<E>(e, prev.next);
        prev.next = node;
        if (node.next == null) last = node;
        prev = prev.next;
        size++;
    } 

    /** IFF !isEnd(): removes from a List the Element that
     * occupies its POI, which remains unaltered.
     **/  
    public void remove() {
        size--;
        if (prev.next == last) last = prev;
        prev.next = prev.next.next;
    }

    /** move the POI to the first element of the list
     **/
    public void begin() { prev = first; }

    /** IFF !isEnd(): advances by one item a List's POI
     **/
    public void next() { prev = prev.next; }

    /** move the POI after the last element of the List
     **/
    public void end() { prev = last; }

    /** IFF !isEnd(): obtains the Element at the POI of a List.
     *
     * @return E, the Element that occupies the List's POI.
     */
    public E get() {
        return prev.next.data;
    }

    /** checks whether the POI of a List is at the end
     * (after the last element).
     *
     * @return true if a List's POI is at its end and
     * false otherwise
     **/
    public boolean isEnd() {
        return prev == last;
    }

    /**  checks whether a List with POI is empty
     *
     * @return true it a ListPOI is empty and
     * false otherwise
     **/
    public boolean isEmpty() {
        return first == last;
    }

    /** returns the size of a List, i.e., the number of elements it contains
     *
     * @return int, the number of elements of a ListPOI.
     **/
    public int size() { return size; }

    /** returns a String with the Elements of a List with POI
     * in insertion order.
     * 
     * @return String that contains the Elements of a List with POI,
     * in the same format as Java's standard for arrays.
     **/
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        LinkedNode<E> aux = first.next;
        for (int i = 1; i < size; i++, aux = aux.next) {
            s.append(aux.data.toString() + ", ");
        }
        if (size != 0) {
            s.append(aux.data.toString() + "]");
        } else { s.append("]"); }
        return s.toString();
    }
    
    public static <E extends Comparable<E>> Queue<E> removesSort(ListPOI<E> p, ListPOI<E> q){        
        p.begin();
        Queue<E> cola = null;
        while(!p.isEnd()){
            q.begin();
            while(!q.isEnd()){
                q.next();
                if(q.get().compareTo(p.get()) == 0){
                    cola.enqueue((E)q);
                }
            }
            p.next();
        }
        return cola;
    }
}
