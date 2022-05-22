package primeroB.LinkedSequences.LinkedIntSequences;

public class LinkedIntSequence {
    NodeInt first;
    NodeInt last;
    NodeInt cursor;

    int size = 0;

    //creates an empty list of nodes
    public LinkedIntSequence(){
        first = last = cursor = null;
        size = 0;
    }

    //GETTERS AND SETTERS
    public int getSize(){
        return size;
    }

    public NodeInt getFirst(){
        return first;
    }
    
    public NodeInt getLast(){
        return last;
    }

    public NodeInt getCursor(){
        return cursor;
    }

    public boolean append(int x)
    {
        NodeInt node = new NodeInt(x);

        if (this.getSize() == 0) {
            first = last = cursor = node; // trivial
        } else {
            last.setNext(node); // (1) connects the last node with the new one such that the new node is the next of the last one.
            node.setPrevious(last); // (2) connects the new node with the last one such that the last node is the previous of the new one.
            last = node; // (3) updates 'last' attribute to reference the last node in the list.
        }
        ++size;
        return true;
    }

    public boolean searchIsThereElemenInteger(int k){
        NodeInt aux = this.first;
        while(aux != null){
            if(aux.getData() == k){
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public String toString(){
        NodeInt aux = this.first;
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

    public boolean RemoveElem(int n){
        NodeInt aux = this.first;
        while(aux != null){
            if(aux.getData() == n && aux.previous != null && aux.next != null){
                aux.previous.setNext(aux.next);
                aux.next.setPrevious(aux.previous);
                aux = null;
                System.out.print("The element has been erased successfully. Status is: ");
                size--;
                return true;
            }
            else{
                if(aux.getData() == n && aux.previous == null){
                    this.first = aux.next;
                    aux = null;
                    System.out.print("The element has been erased successfully. Status is: ");
                    size--;
                    return true;
                }
                else if(aux.getData() == n && aux.next == null){
                    this.last = aux.previous;
                    aux = null;
                    System.out.print("The element has been erased successfully. Status is: ");
                    size--;
                    return true;
                }
            }
            aux = aux.next;
        }
        System.out.print("The element has not been found. Status of deletion is: ");
        return false;
    }
}
