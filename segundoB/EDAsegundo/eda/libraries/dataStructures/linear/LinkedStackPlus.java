package libraries.dataStructures.linear;

public class LinkedStackPlus<E extends Comparable<E>> extends LinkedStack<E>{
    
    /* Método que usa atributos del objeto */
    public E baseAtributos(){
        LinkedNode<E> x = top;
        while(x.next != null){
            x =  x.next;
        }
        return (E) x;
    }

    /* Método que usa atributos del objeto */
    public E baseMetodos(){
        E aux1, aux2 = pop(); // aux1 == aux2!!
        if(isEmpty()){aux1 = aux2;}
        else aux1 = baseMetodos(); // link con el resto de la lista
        push(aux2); // retorna el objeto eliminado a la lista en cuanto la llamada suba.
        return aux1;
    }

    public E minimumAtributos(){
        LinkedNode<E> x = top;
        E aux = null;
        while(x.next != null){
            if(aux == null /* para inicializar el valor en la primera iteración*/
            || x.data.compareTo(aux) < 0) aux = x.data;
            x = x.next;
        }
        return (E) aux;
    }

    public E minimum2() {
        if (isEmpty()) return null;
        E data = pop();
        E minRest = minimum2();
        push(data);
        if (minRest == null || data.compareTo(minRest) < 0) return data;
        return minRest;
    }
}
