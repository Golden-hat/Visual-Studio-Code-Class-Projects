package libraries.dataStructures.linear;

import  libraries.dataStructures.models.*;

public class ArrayStack<E> implements Stack<E> {
    protected E[] theArray;
    protected int top;
    protected static final int DEFAULT_CAPACITY = 50;

    /** creates an empty Stack **/
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        /*TO BE COMPLETED*/
        top = -1;
    }
      
    /** inserts Element e in a Stack, placing it at its top **/
    public void push(E e) {
        /*TO BE COMPLETED*/
    }
      
    // duplicates an array's current capacity
    @SuppressWarnings("unchecked")
    protected void duplicateArray() {
        E[] newArray = (E[]) new Object[theArray.length * 2];
        System.arraycopy(theArray, 0, newArray, 0, top);
        theArray = newArray;
    }
      
    /** IFF !isEmpty():
     * obtains and removes from a list the Element at its top
     */
    public E pop() {
        /*TO BE CHANGED AND COMPLETED*/
        return null;
    }

    /** IFF !isEmpty():
     * obtains the Element at the top of a Stack
     */
    public E top() {
        /*TO BE COMPLETED*/
        return null;
    }
      
    /** checks whether a Stack is empty **/
    public boolean isEmpty() {
        /*CHANGE THIS*/
        return false;
    }
        
    /** returns a String with the Elements of a Stack in LIFO order,
     * or the reverse of its insertion order, with the format used
     * in Java's standard. Thus, if a Stack contains Integers from 1 to 4,
     * in LIFO order, toString returns [4, 3, 2, 1]; if the Stack is
     * empty, then returns []
     */
    public String toString() { 
        StringBuilder res = new StringBuilder();
        res.append("["); 
        /*TO BE COMPLETED*/
        return res.toString(); 
    }
}