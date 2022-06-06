package primeroB.LinkedSequences.QueueIntLinked;

public class NodeInt4Queues{

    public int data;
    public NodeInt4Queues next;

    //CONSTRUCTORS

    public NodeInt4Queues(int value, NodeInt4Queues next){
        this.data = value;
        this.next = next;
    }

    public NodeInt4Queues(int value){
        this.data = value;
    }

    //GETTERS AND SETTERS
    public int getData(){
        return data;
    }

    public void setData(int data){
       this.data = data;
    }
    
    public void setNext(NodeInt4Queues next) {
        this.next = next;
    }

    public NodeInt4Queues getNext() {
        return next;
    }

    //OVERRIDE METHODS
    @Override
    public String toString(){
        return "<" + data + ">";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof NodeInt4Queues) {
            NodeInt4Queues other = (NodeInt4Queues)o;
            return other.data == this.data;
        }
        return false;
    }
}
