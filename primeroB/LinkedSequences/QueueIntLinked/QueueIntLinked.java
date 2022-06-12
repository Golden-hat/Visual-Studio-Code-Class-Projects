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
        while(i < j - 1){
            p = p.next;
            i++;
        }
        aux.first = p.next;
        aux.last = this.last;
        p.next = null;
        aux.size = this.size - j;
        this.last = p;
        this.size = j; 
        return aux;
    }

    public void removeBigThanInOrd(int x){
        NodeInt4Queues aux = this.first;
        NodeInt4Queues prev = null;

        int i = 0;
        while(aux != null && aux.data <= x){
            prev = aux;
            aux = aux.next;
            i++;
        }

        if(aux == first){
            first = null;
            last = null;
        }
        else{
            prev.next = null;
            last = prev;
        }
        size = i;
    }

    public void sneak(int x){
        NodeInt4Queues aux = first;
        NodeInt4Queues prevAux = null;

        while(aux != null && aux.data != x){
            prevAux = aux;
            aux = aux.next;
        }

        if(aux != null && prevAux != null){
            NodeInt4Queues priorNextAux = aux.next;
            NodeInt4Queues priorFirst = this.first;
            aux.next = priorFirst;
            this.first = aux;
            prevAux.next = priorNextAux;
        }
        else if(prevAux == null){
            System.out.println("The selected element is already the head of the queue.");
        }
    }

    public void OnlyOneElement(){
        if(size != 1){
            NodeInt4Queues ant = this.first;
            NodeInt4Queues aux = first.next;

            while(aux != null){
                if(aux.data == ant.data){
                    ant.next = aux.next;
                    if(ant.next == null){
                        this.last = ant;
                    }
                    size--;
                }
                else{
                    ant = aux;
                }
                aux = aux.next;
            }
        }
    }

    public int size(){
        return this.size;
    }
}
