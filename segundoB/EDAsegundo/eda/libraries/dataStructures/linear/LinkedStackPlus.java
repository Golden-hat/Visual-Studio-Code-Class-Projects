package libraries.dataStructures.linear;

public class LinkedStackPlus<E> extends LinkedStack<E>{
    
    /* Método que usa atributos del objeto */
    public E baseAtributos(){
        LinkedNode<E> x = top;
        while(x.next != null){
            x =  x.next;
        }
        return (E) x;
    }
}
