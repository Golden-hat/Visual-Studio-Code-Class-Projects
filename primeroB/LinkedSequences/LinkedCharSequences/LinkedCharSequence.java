package primeroB.LinkedSequences.LinkedCharSequences;

public class LinkedCharSequence {
    NodeChar first;
    NodeChar last;
    NodeChar cursor;

    int size = 0;

    //creates an empty list of nodes
    public LinkedCharSequence(){
        first = last = cursor = null;
        size = 0;
    }

    //GETTERS AND SETTERS
    public int getSize(){
        return size;
    }

    public NodeChar getFirst(){
        return first;
    }
    
    public NodeChar getLast(){
        return last;
    }

    public NodeChar getCursor(){
        return cursor;
    }

    public boolean append(char x)
    {
        NodeChar node = new NodeChar(x);

        if (this.getSize() == 0) {
            first = last = cursor = node; // trivial
        } else {
            last.setNext(node); // (1) connects the last node with the new one such that the new node is the next of the last one.
            last = node; // (3) updates 'last' attribute to reference the last node in the list.
        }
        ++size;
        return true;
    }

    public void addElement(char x, char k){
        NodeChar foundElem = returnFoundElement(k);
    
        if(foundElem != null){
            NodeChar aux = foundElem.next;
            NodeChar InsertObject = new NodeChar(x, aux);
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

    public void appendArrayChar(char[] a){
        for(int i = 0; i < a.length; i++){
            NodeChar node = new NodeChar(a[i]);
            if (this.getSize() == 0) {
                first = last = cursor = node; // trivial
            } else {
                last.setNext(node); // (1) connects the last node with the new one such that the new node is the next of the last one.
                last = node; // (3) updates 'last' attribute to reference the last node in the list.
            }
            size++;
        }
    }

    public boolean searchIsThereElementInteger(int k){
        NodeChar aux = this.first;
        while(aux != null){
            if(aux.getData() == k){
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public NodeChar returnFoundElement(int k){
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
            NodeChar aux = returnFoundElement(k);
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
        NodeChar aux = this.first;
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

    public boolean RemoveElem(char n){
        NodeChar aux = this.first;
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
    
    public NodeChar convertToLinkedSeq(String s){
        NodeChar res = null;
        int n = this.size;
        NodeChar aux = null;

        if(s != null) {
            int i = s.length() - 1;
            while (i >= 0) {
                char c = s.charAt(i);
                res = new NodeChar(c, res);
                size++;
                if(i == s.length()-1){
                    aux = res;
                }
                i--;
            }
            if(n == 0){
                this.first = res;
                this.last = aux;
            }
            else{
                this.last.next = res;
            }
        }
        return res;
    }
}
