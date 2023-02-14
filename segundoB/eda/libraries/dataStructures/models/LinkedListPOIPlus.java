package libraries.dataStructures.models;
import libraries.dataStructures.linear.LinkedListPOI;
import libraries.exceptions.ElementNotFound;

public class LinkedListPOIPlus<E> extends LinkedListPOI<E> implements ListPOIPlus<E>{
    public boolean contains(E e){
        begin();
        while(!isEnd() && !get().equals(e)) next();
        if(isEnd()) return false;
        return true;
    }
    
    /** removes the first instance of Element e in a List with POI
     * and returns true, or returns false if e is not in the List
     */
    public boolean remove(E e){
        begin();
        while(!isEnd()){
            if(get().equals(e)){
                remove();
                return true;
            }
            next();
        }
        return false;
    }
    
    /** if Element e appears in a List with POI, removes its last
     * instance and returns it back to the user; otherwise it signals
     * the non-existance of e by throwing an ElementNotFound Exception
     */
    public E removeLast(E e) throws ElementNotFound{
        begin();
        int aux = 0;
        while(!isEmpty()){
            if(get().equals(e)){
                aux++;
            }
        }
        if(aux == 0) {throw new ElementNotFound("element can't be found within the list");}
        while(aux>0){
            if(get().equals(e)){
                aux--;
            }
            next();
        }
        E p = get();
        remove();
        return p;
    }
    
    /** if Element e appears in a List with POI, removes all
     * its appearances in it; otherwise it signals the non-existence
     * by throwing an ElementNotFound Exception
     */
    public void removeAll(E e) throws ElementNotFound{
        begin();
        int aux = 0;
        while(!isEmpty()){
            if(get().equals(e)){
                aux++;
            }
        }
        if(aux == 0) {throw new ElementNotFound("element(s) can't be found within the list");}
        while(aux>0){
            if(get().equals(e)){
                aux--;
                remove();
            }
            next();
        }
    }
    
    /** removes all Elements contained in a List with POI, leaving it empty **/
    public void clear(){
        begin();
        while(!isEmpty()){
            remove();
            next();
        }
    }
    
    /** adds all elements of 'other' at the end of this List
     * i.e., if 'this' contains "1, 2, 3" and 'other' contains "4, 5",
     * the state of 'this' after calling this method should be
     * "1, 2, 3, 4, 5", and 'other' should remain unaltered.
     */
    public void addAll(ListPOI<E> other){
        end();
        for(int i = 0; i < other.size(); i++){
            add(other.get());
            end();
        }
    }
    
    public void search(E e){
        begin();
        while(!isEnd() && !get().equals(e)){
            next();
        }
    }
    
    public String toString(){return super.toString();}

    /** reverses a List in-situ from its POI **/
    public void reverseFromPOI(){
        for(int i = 0; i < size(); i++){
            
        }
    }
}
