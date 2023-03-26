package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;
import java.util.ArrayDeque;

public class ArrayDequeCola<E> extends ArrayDeque<E> implements Queue<E>{
    @Override
    public void enqueue(E e){
        add(e);
    }

    @Override
    public E dequeue(){
        E aux = remove();
        return aux;
    }
    
    @Override
    public E first(){
        return peekFirst();
    }
    
}