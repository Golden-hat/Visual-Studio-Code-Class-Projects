package libraries.dataStructures.linear;

public class SortedLinkedListPOI<E extends Comparable> extends LinkedListPOI<E>{
    @Override
    public void add(E e){
        begin();
        while(!isEnd() && get().compareTo(e) < 1){
            next();
        }
        super.add(e);
    }
}
