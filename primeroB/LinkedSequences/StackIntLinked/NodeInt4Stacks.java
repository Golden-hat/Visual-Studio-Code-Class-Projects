package primeroB.LinkedSequences.StackIntLinked;

public class NodeInt4Stacks {

    public int data;
    public NodeInt4Stacks previous;

    //CONSTRUCTORS

    public NodeInt4Stacks(int value, NodeInt4Stacks previous){
        this.data = value;
        this.previous = previous;
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
    
    public void setPrevious(NodeInt4Stacks previous) {
        this.previous = previous;
    }

    public NodeInt4Stacks getPrevious() {
        return previous;
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
