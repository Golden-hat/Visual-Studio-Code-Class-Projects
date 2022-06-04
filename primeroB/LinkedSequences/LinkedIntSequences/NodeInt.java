package primeroB.LinkedSequences.LinkedIntSequences;

public class NodeInt {

    public int data;
    public NodeInt next;
    public NodeInt previous;

    //CONSTRUCTORS
    public NodeInt(int value, NodeInt next){
        this.data = value;
        this.next = next;
    }

    public NodeInt(int value){
        this.data = value;
    }

    //GETTERS AND SETTERS
    public int getData(){
        return data;
    }

    public NodeInt getNext(){
        return next;
    }

    public void setData(int data){
       this.data = data;
    }

    public void setNext(NodeInt next){
        this.next = next;
    }

    public void setPrevious(NodeInt previous) {
        this.previous = previous;
    }

    public NodeInt getPrevious() {
        return previous;
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
