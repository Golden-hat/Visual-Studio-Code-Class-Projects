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
        else{throw new NoSuchElementException("Queue is empty, this method returns the following value: ");}
    }

    public int element(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty, this method returns the following value: ");
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

    public int size(){
        return this.size;
    }
}
