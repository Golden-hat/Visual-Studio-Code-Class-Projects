package libraries.dataStructures.models;

/**
 * Model for a List with a Point of Interest (POI), or with
 * Sequential Access to a Collection's Elements
 */
public interface ListPOI<E> {
    // Modifier methods - state of the List with POI
    /** adds e to a List before the Element at its POI,
     * which remains unaltered
     */
    void add(E e);
    
    /** IFF !isEnd():
     * removes from a List the Element that occupies its POI,
     * which remains unaltered
     */
    void remove();

    // Modifier methods - state of a List's POI
    /** move the POI to the first element of the list **/
    void begin();
    /** IFF !isEnd(): advances by one item a List's POI **/
    void next();
    /** move the POI after the last element of the List **/
    void end();

    // Getter methods - state of a List with POI:
    /** IFF !isEnd(): obtains the Element at the POI of a List **/
    E get();
    /** checks whether the POI of a List is at the end (after the last element) **/
    boolean isEnd();
    /** checks whether a List with POI is empty **/
    boolean isEmpty();
    /** returns the size of a List, i.e., the number of elements it contains **/
    int size();
}