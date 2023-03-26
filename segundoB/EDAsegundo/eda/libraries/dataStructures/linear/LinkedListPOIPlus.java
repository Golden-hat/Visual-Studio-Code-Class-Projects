package libraries.dataStructures.linear;
import libraries.exceptions.ElementNotFound;
import libraries.dataStructures.models.*;

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
        LinkedNode<E> lastE = null;
        begin();
        while(!isEnd()){
            if(get().equals(e)){
                lastE = prev;
            }
            next();
        }
        if(lastE == null) {throw new ElementNotFound("element can't be found within the list");}
        else {
            prev = lastE; remove(); return (E) prev;
        }
    }
    
    /** if Element e appears in a List with POI, removes all
     * its appearances in it; otherwise it signals the non-existence
     * by throwing an ElementNotFound Exception
     */
    public void removeAll(E e) throws ElementNotFound{
        begin();
        while(!isEnd()){
            if (get().equals(e)){
                remove();
            }
            else {this.next();}
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
        this.end();
        other.begin();
        for(int i = 0; i < other.size(); i++){
            this.add(other.get());
            other.next();
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
    //los reverses son recursivos! Normalmente...
    public void reverseFromPOI(){ 
        if(!isEmpty()){
            //begin();
            E data = get();
            remove();
            reverseFromPOI();
            add(data);
        }
    }

    public void shiftLeft(){
        if(size() <= 1){
            return;
        }
        last.next = first.next;
        first.next = first.next.next;
        last = last.next;
        last.next = null;

    }
}
