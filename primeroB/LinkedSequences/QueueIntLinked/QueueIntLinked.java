package primeroB.LinkedSequences.QueueIntLinked;
import java.util.*;

public class QueueIntLinked {

    public int size;
    public NodeInt4Queues first;
    public NodeInt4Queues last;

    public QueueIntLinked(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public void addToQueue(int x){
        NodeInt4Queues elem = new NodeInt4Queues(x);
        if(last != null){last.next = elem;}
        else{this.first = elem;}
        this.last = elem;
        size++;
    }

    public void ArrayAddToQueue(int x[]){
        NodeInt4Queues p = null;
        for(int i = 0; i < x.length; i++){
            p = new NodeInt4Queues(x[i]);
            if(i == 0 && size == 0){
                this.first = this.last = p;
            }
            this.last.next = p;
            this.last = p;
            size++;
        }
    }

    public int removeFromQueue(){
        if(this.size > 0){
            int x = this.first.getData();
            this.first = first.next;
            if(first == null){
                last = null;
            }
            size--;
            return x;
        }
        else{throw new NoSuchElementException("Queue is empty.");}
    }

    public int element(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty.");
        }
        else{
            return this.first.getData();
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        NodeInt4Queues aux = this.first;
        String elem = "{";
        while(aux != null){
            if(aux == this.first){
                elem += aux.getData();
                aux = aux.next;
            }
            else{
                elem += ", "+aux.getData();
                aux = aux.next;
            }
        }
        return "The elements of the linked sequence (from most recently added to last) are the following: \n"+elem+"}";
    }

    public QueueIntLinked divideQueue(){
        QueueIntLinked aux = new QueueIntLinked();
        int j = this.size/2;
        
        NodeInt4Queues p = this.first;
        int i = 0;
        while(i < j){
            p = p.next;
            i++;
        }
        aux.first = p;

        NodeInt4Queues q = aux.first;
        i = 0;
        while(i < this.size-j){
            q = q.next;
            i++;
        }
        aux.last = q;
        return aux;
    }

    public int size(){
        return this.size;
    }
}
