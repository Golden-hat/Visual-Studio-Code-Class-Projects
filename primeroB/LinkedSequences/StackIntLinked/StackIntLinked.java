package primeroB.LinkedSequences.StackIntLinked;
import java.util.NoSuchElementException;

public class StackIntLinked {
    public static NodeInt4Stacks top = null;
    public int size = 0;

    public StackIntLinked(){
        top = null;
        size = 0;
    }

    public void push(int x){
        top = new NodeInt4Stacks(x, top);
        size++;
    }

    public void printToScreen(){
        NodeInt4Stacks aux = top;
        while(aux != null){
                System.out.println(aux.getData());
                aux = aux.previous;
        }
    }

    @Override
    public String toString(){
        NodeInt4Stacks aux = top;
        String elem = "";
        while(aux != null){
                System.out.println(elem+aux.getData());
                aux = aux.previous;
        }
        return elem+"\n";
    }

    public int getSize(){
        return size;
    }

    public NodeInt4Stacks pop(){
        try{           
            NodeInt4Stacks aux = top;
            top = top.previous;
            size--;
            return aux;
        }
        catch (Exception e){
            throw new NoSuchElementException("The pile is empty.");
        }
    }

    public NodeInt4Stacks peek(){
        try{
            System.out.println(top.getData());
            return top;
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
