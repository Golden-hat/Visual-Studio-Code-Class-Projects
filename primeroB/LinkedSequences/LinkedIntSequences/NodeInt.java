package primeroB.LinkedSequences.LinkedIntSequences;

public class NodeInt {

    public int data;
    public NodeInt next;
    public NodeInt previous;

    //CONSTRUCTORS
    public NodeInt(int value, NodeInt next, NodeInt previous){
        this.data = value;
        this.next = next;
        this.previous = previous;
    }

    public NodeInt(int value, NodeInt next){
        this(value, null, next);
    }

    public NodeInt(int value){
        this(value, null , null);
    }

    //GETTERS AND SETTERS
    public int getData(){
        return data;
    }

    public NodeInt getNext(){
        return next;
    }

    public NodeInt getPrevious(){
        return previous;
    }

    public void setData(int data){
       this.data = data;
    }

    public void setNext(NodeInt next){
        this.next = next;
    }

    public void setPrevious(NodeInt previous){
        this.previous = previous;
    }

    //OVERRIDE METHODS
    @Override
    public String toString(){
        return "<" + data + ">";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof NodeInt) {
            NodeInt other = (NodeInt)o;
            return other.data == this.data;
        }
        return false;
    }
}
