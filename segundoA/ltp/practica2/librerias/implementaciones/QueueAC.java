package practica2.librerias.implementaciones;

import practica2.librerias.modelos.Queue;

/**
 * class QueueAC<T>
 * It is the implementation of a Queue<T> 
 * using a circular array of variable length.
 * 
 * @author LTP 
 * @version 2020-21
 * @param <T>
 */

public class QueueAC<T> implements Queue<T> { 
    
    private T[] theArray; // array of generic type T
    private int first;    // index of the first element
    private int last;     // index of the last element
    private int size;     // number of elements
    private static final int MAX = 50; // initial size
    
    /** The object constructor 
     * 
     * The compiler warns us (warning)
     * that the pure type corresponding to T in (1)
     * will be applied at run time.
     * With this directive we say that
     * do not show us the warning since the coercion is safe.
     */
    @SuppressWarnings({ "unchecked" })     
    public QueueAC() {
        theArray = (T[]) (new Object [MAX]); // (1)
        size = 0; 
        first = 0; 
        last = -1;
    }
  
    /** Private method for expanding the array when it is necessary 
     */   
    @SuppressWarnings({ "unchecked" })    
    private void expandArray() {    
        T[] arrayAux = (T[]) (new Object [theArray.length * 2]);
        int i = 0;
        int sizeAux = size;
        while ( !isEmpty() ) {
            try {
                arrayAux[i++] = dequeue();
            } 
            catch (Exception e) {
                System.out.println("Error attempting to extend a queue");
            }
        }
        theArray = arrayAux;
        first = 0;
        last = sizeAux - 1;
        size = sizeAux;
    }  
    
    /** Private method for increasing the array indexes 
     *  in a ciclic way (module theArray.length)
     */
    private int increase(int i) {
        return (i + 1) % theArray.length;
    }
    
    /** It returns the content of the queue 
     *  according to the following format:
     *   <- item0 <- item1 <- item2 <- ... <- itemN 
     *  where N = size() - 1
     *  and each item is concatenated 
     *  according to the format defined in its type
     *  @return the content of the queue 
     */ 
    public String toString() {
        String s = "";
        int i = first;
        for (int k = 1; k <= size; k++) {
            s += " <- " + theArray[i];
            i = increase(i);
        }
        return s;
    } 
    
    // Implementation of the operations defined 
    // in the Queue<T> interface
    
    // Methods that change the queue' state:
  
    /** Inserts the element at the end of the queue
     *  @param e element to be inserted 
     */  
    public void enqueue(T e) {
        // TO COMPLETE ...
    } 
  
    /** Queries and extracts the first element,
     *  only if the queue is not empty 
     *  @return the first element
     */
    public T dequeue() {
        // TO COMPLETE / CHANGE ...
        return null;
    } 
  
    // Methods that query the queue' state:
    
    /** Queries the number of elements of the queue
     *  @return the number of elements
     */
    public int size() {
        // TO COMPLETE  / CHANGE ...
        return 0;
    } 
  
    /** Queries the first element, in order of insertion,
     *  only if the queue is not empty 
     *  @return the first element
     */
    public T first() {
        // TO COMPLETE / CHANGE ... 
        return null;
    } 
  
    /** Verifies if the queue is empty
     *  @return true iif the queue is empty
     */
    public boolean isEmpty() {
        // TO COMPLETE / CHANGE ... 
        return true;
    } 
}