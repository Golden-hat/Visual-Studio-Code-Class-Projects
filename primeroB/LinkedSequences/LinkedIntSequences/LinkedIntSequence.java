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
            last = node; // (3) updates 'last' attribute to reference the last node in the list.
        }
        ++size;
        return true;
    }

    public void addElement(int x, int k){
        NodeInt foundElem = returnFoundElement(k);
    
        if(foundElem != null){
            NodeInt aux = foundElem.next;
            NodeInt InsertObject = new NodeInt(x, aux);
            foundElem.setNext(InsertObject);
            System.out.println("The element has been added to its corresponding position.");
            size++;
        }
        else{
            append(x);
            System.out.println("The element has been added to the last position.");
            size++;
        }
    }

    public NodeInt appendArrayNumbers(int[] a){
        for(int i = 0; i < a.length; i++){
            NodeInt node = new NodeInt(a[i]);
            if (this.getSize() == 0) {
                first = last = cursor = node; // trivial
            } else {
                last.setNext(node); // (1) connects the last node with the new one such that the new node is the next of the last one.
                last = node; // (3) updates 'last' attribute to reference the last node in the list.
            }
            size++;
        }
        NodeInt FirstValue = new NodeInt(a[0]);
        return FirstValue;
    }

    public void adelantar(int x){
        NodeInt aux = this.first;
        NodeInt prevAux = null;

        while(aux != null && aux.data != x){
            prevAux = aux;
            aux = aux.next;
        }

        if(prevAux != null){
            int dato = prevAux.data;
            prevAux.data = aux.data;
            aux.data = dato;
        }
        else{
            int dato = this.last.data;
            this.last.data = this.first.data;
            this.first.data = dato;
        }
    }

    public boolean searchIsThereElementInteger(int k){
        NodeInt aux = this.first;
        while(aux != null){
            if(aux.getData() == k){
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public NodeInt returnFoundElement(int k){
        cursor = this.first;
        while(cursor != null){
            if(cursor.getData() == k){
                return cursor;
            }
            cursor = cursor.next;
        }
        return null;
    }

    public boolean deleteFoundElementV2(int k){
        try{
            NodeInt aux = returnFoundElement(k);
            if(aux.previous != null && aux.next != null){
                aux.previous.setNext(aux.next);
                System.out.print("The element has been erased successfully. Status is: ");
                size--;
                return true;
            }
            else{
                if(aux.previous == null){
                    this.first = aux.next;
                    System.out.print("The element has been erased successfully. Status is: ");
                    size--;
                    return true;
                }
                else if(aux.next == null){
                    this.last = aux.previous;
                    System.out.print("The element has been erased successfully. Status is: "); 
                    size--;
                    return true;
                }
            }
        }
        catch(Exception e){
            System.err.print("Element does not exist. Status of deletion is: ");
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
