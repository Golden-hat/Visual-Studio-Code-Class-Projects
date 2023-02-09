package libraries.dataStructures.models;

public interface List<E> {
    // Modifier methods - state of the List:
    /** IFF 0<=i<=size():
     * inserts the element e in the position i of a List
     */
    void add(E e, int i);
    
    /** IFF 0<=i<size(): 
     * removes the element that occupies position i in a List
     */
    void remove(int i);
    
    // Getter methods - state of the List:
    /** IFF 0<=i<size(): 
     * returns the element that occupies position i in a List
     */
    E get(int i);
    
    /** checks whether a List is empty
     */
    boolean isEmpty();
    
    /** returns the size of a list, or the amount of elements it contains
     */
    int size();
}