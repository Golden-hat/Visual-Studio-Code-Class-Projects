package libraries.dataStructures.models;

public interface Queue<E> {
    // Modifier methods - state of a Queue:
    /** adds Element e to a Queue, or places it at the end
     */
    void enqueue(E e);
    
    /** IFF !isEmpty():
     * obtains and removes from a Queue its first Element
     */
    E dequeue();
    
    // Getter methods - state of a Queue:
    /** IFF !isEmpty():
     * obtains the first Element of a Queue,
     * i.e., first pushed into the Queue
     */
    E first();
    
    /** checks whether a Queue is empty
     */
    boolean isEmpty();
}