package primeroB.LinkedSequences.StackIntLinked;
import java.util.NoSuchElementException;

public class StackIntLinked {
    public NodeInt4Stacks top = null;
    public int size = 0;

    public StackIntLinked(){
        top = null;
        size = 0;
    }

    //copy of an existing stack. Exam 2017.
    public StackIntLinked(StackIntLinked s){
        this();
        if (!s.empty()){
            NodeInt4Stacks p = this.top = new NodeInt4Stacks(s.top.getData());
            NodeInt4Stacks n = s.top.getNext();

            while(null != n){
                p.setNext(new NodeInt4Stacks(n.getData()));
                p = p.getNext();
                n = n.getNext();
            }
        }
        this.size = s.size;
    }

    public void push(int x){
        top = new NodeInt4Stacks(x, top);
        size++;
    }
    
    public void ArrayPush(int[] a){
        for(int i = 0; i < a.length; i++){
            top = new NodeInt4Stacks(a[i], top);
            size++;
        }
    }

    public void printToScreen(){
        NodeInt4Stacks aux = top;
        while(aux != null){
            System.out.println(aux.getData());
            aux = aux.next;
        }
    }

    @Override
    public String toString(){
        NodeInt4Stacks aux = top;
        String elem = "";
        while(aux != null){
                System.out.println(elem+aux.getData());
                aux = aux.next;
        }
        return elem+"\n";
    }

    public int getSize(){
        return size;
    }

    public int pop(){
        try{           
            NodeInt4Stacks aux = top;
            top = top.next;
            size--;
            return aux.getData();
        }
        catch (Exception e){
            throw new NoSuchElementException("The pile is empty.");
        }
    }

    public int peek(){
        try{
            System.out.println(top.getData());
            return top.getData();
        }
        catch (Exception e){
            throw new NoSuchElementException("The pile is empty.");
        }
    }

    public boolean empty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }

}
