package libraries.dataStructures.models;

/**
 * Model of a Priority Queue (PQ), or a Dynamic Search of the highest
 * priority Element in a Collection
 */
public interface PriorityQueue<E extends Comparable<E>> {
    // Modifier methods - state of a Priority Queue (PQ)
    /** taking into account its priority, adds Element e
     *  to a Priority Queue
     */
    void add(E e);
    
    /** IFF !isEmpty():
     * obtains and removes the Element with the highest priority in a PQ
     */
    E removeMin();

    // Getter methods - state of a Priority Queue (PQ)
    /** IFF !isEmpty():
     * returns the Element with the highest priority in a PQ
     */
    E getMin();
    
    /** checks whether a PQ is empty
     */
    boolean isEmpty();
}