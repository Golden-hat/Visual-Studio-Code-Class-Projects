package primeroB.LinkedSequences.StackIntLinked;

public class NodeInt4Stacks {

    public int data;
    public NodeInt4Stacks next;

    //CONSTRUCTORS

    public NodeInt4Stacks(int value, NodeInt4Stacks next){
        this.data = value;
        this.next = next;
    }

    public NodeInt4Stacks(int value){
        this.data = value;
    }

    //GETTERS AND SETTERS
    public int getData(){
        return data;
    }

    public void setData(int data){
       this.data = data;
    }
    
    public void setNext(NodeInt4Stacks next) {
        this.next = next;
    }

    public NodeInt4Stacks getNext() {
        return next;
    }

    //OVERRIDE METHODS
    @Override
    public String toString(){
        return "<" + data + ">";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof NodeInt4Stacks) {
            NodeInt4Stacks other = (NodeInt4Stacks)o;
            return other.data == this.data;
        }
        return false;
    }
}
