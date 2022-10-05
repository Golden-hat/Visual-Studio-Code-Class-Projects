package primeroB.LinkedSequences.LinkedCharSequences;

public class NodeChar {

    public char data;
    public NodeChar next;
    public NodeChar previous;

    //CONSTRUCTORS
    public NodeChar(char value, NodeChar next){
        this.data = value;
        this.next = next;
    }

    public NodeChar(char value){
        this.data = value;
    }

    //GETTERS AND SETTERS
    public char getData(){
        return data;
    }

    public NodeChar getNext(){
        return next;
    }

    public void setData(char data){
       this.data = data;
    }

    public void setNext(NodeChar next){
        this.next = next;
    }

    public void setPrevious(NodeChar previous) {
        this.previous = previous;
    }

    public NodeChar getPrevious() {
        return previous;
    }

    //OVERRIDE METHODS
    @Override
    public String toString(){
        return "<" + data + ">";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof NodeChar) {
            NodeChar other = (NodeChar)o;
            return other.data == this.data;
        }
        return false;
    }
}
