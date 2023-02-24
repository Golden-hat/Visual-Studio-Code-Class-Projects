package libraries.dataStructures.models;
import libraries.exceptions.ElementNotFound;

public interface ListPOIPlus<E> extends ListPOI<E> {
    
    /** checks whether the Element e is in a List with POI **/
    boolean contains(E e);
    
    /** removes the first instance of Element e in a List with POI
     * and returns true, or returns false if e is not in the List
     */
    boolean remove(E e);
    
    /** if Element e appears in a List with POI, removes its last
     * instance and returns it back to the user; otherwise it signals
     * the non-existance of e by throwing an ElementNotFound Exception
     */
    E removeLast(E e) throws ElementNotFound;
    
    /** if Element e appears in a List with POI, removes all
     * its appearances in it; otherwise it signals the non-existence
     * by throwing an ElementNotFound Exception
     */
    void removeAll(E e) throws ElementNotFound;
    
    /** removes all Elements contained in a List with POI, leaving it empty **/
    void clear();
    
    /** adds all elements of 'other' at the end of this List
     * i.e., if 'this' contains "1, 2, 3" and 'other' contains "4, 5",
     * the state of 'this' after calling this method should be
     * "1, 2, 3, 4, 5", and 'other' should remain unaltered.
     */
    void addAll(ListPOI<E> other);
    
    void search(E e);
    
    String toString();

    /** reverses a List in-situ from its POI **/
    void reverseFromPOI();
}