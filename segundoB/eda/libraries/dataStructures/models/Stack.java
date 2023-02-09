package libraries.dataStructures.models;

public interface Stack<E> {
    // Modifier methods - state of a Stack:
    /** pushes an Element e onto a Stack, or places it at its top
     */
    void push(E e);
    
    /** IFF !isEmpty():
     * obtains and removes from a list the Element at its top
     */
    E pop();

    // Getter methods - state of a Stack:
    /** IFF !isEmpty():
     * obtains the Element at the top of a Stack
     */
    E top();
    
    /** checks whether a Stack is empty
     */
    boolean isEmpty();
}