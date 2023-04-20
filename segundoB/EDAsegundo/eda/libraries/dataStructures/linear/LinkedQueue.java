package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;

public class LinkedQueue<E> implements Queue<E> {
    
    protected LinkedNode<E> first, last = null;
    protected int size;

    /* Constructor */
    public LinkedQueue(){
        size = 0;
        first = last = null;
    }

    public void enqueue(E e){
        LinkedNode<E> n = new LinkedNode<E>(e);
        /* we need to check whether the queue is empty
         * so that we can set the 1st node to be first.
         */
        if(last == null){first = n;}
        else this.last.next = n;
        this.last = n;
        size++;
    }   

    public E dequeue(){
        if(!isEmpty()){
            LinkedNode<E> n = first;
            first = first.next;
            if(first == null){last = null;}
            size--;
            return (E) n;
        }
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        return (E) this.first;
    }

    public String toString(){
        String s = "(";
        if(size == 0){
            return "()";
        }
        else{
            LinkedNode<E> n = this.first;
            while(n != this.last){
                s += n.data.toString()+", ";
                n = n.next;
            }
            s += this.last.data.toString();
        }
        return s+").";
    }

}
