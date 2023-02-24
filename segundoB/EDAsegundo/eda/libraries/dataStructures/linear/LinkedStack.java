package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;

public class LinkedStack<E> implements Stack<E> {
        
    protected LinkedNode<E> top;
    protected int size;

    /** creates an empty Stack **/
    public LinkedStack() {
        this.size = 0;
        top = null;
    }
      
    /** pushes an Element e onto a Stack, or places it at its top **/
    public void push(E e) {
        top = new LinkedNode<E>(e, top);
        size++;
    }
      
    /** IFF !isEmpty():
     * obtains and removes from a list the Element at its top
     */
    public E pop() {
        E dataS = top.data;
        if(!this.isEmpty()){   
            top = top.next;
            size--;
            return dataS;
        }
        return null;
    }
      
    /** IFF !isEmpty():
     * obtains the Element at the top of a Stack
     */
    public E top() {
        return top.data;
    }
      
    /** checks whether a Stack is empty **/
    public boolean isEmpty() {
        return (size == 0);
    }
      
    /** returns a String with the Elements of a Stack in LIFO order,
     * or the reverse of its insertion order, with the format used
     * in Java's standard. Thus, if a Stack contains Integers from 1 to 4,
     * in LIFO order, toString returns [4, 3, 2, 1]; if the Stack is
     * empty, then returns []
     */
    public String toString() { 
        StringBuilder res = new StringBuilder();
        LinkedNode<E> aux = top;
        if(this.isEmpty()){
            res.append("[]");
        }
        else{
            res.append("["); 
            for(int i = size-1; i >= 1; i--){
                res.append(aux.data.toString()+", ");
                aux = aux.next;
            }
            res.append(top.data+"]");
        }
        return res.toString();  
    }
}