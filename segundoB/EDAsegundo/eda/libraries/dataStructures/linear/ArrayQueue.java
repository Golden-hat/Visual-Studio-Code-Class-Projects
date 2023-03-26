package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;

public class ArrayQueue<E> implements Queue<E> {
    protected E[] theArray;
    protected int qEnd;
    protected int qBegin;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 30000;
   
    /** creates an empty Queue **/
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        theArray = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        qBegin = 0;
        qEnd = 0;
    }
    
    /** adds Element e to a Queue, or places it at its end **/
    //  IFF there is no space left in theArray, its size is duplicated
    public void enqueue(E e) {
        if (size == theArray.length ) duplicateCircularArray();
        theArray[qEnd] = e;
        qEnd = increment(qEnd);
        size++;
    }
    
    // duplicates the current size of a circular array
    @SuppressWarnings("unchecked")
    protected void duplicateCircularArray() {
        E[] newArray = (E[]) new Object[theArray.length * 2];
        for (int i = 0; i < size; i++, qBegin = increment(qBegin))
            newArray[i] = theArray[qBegin];
        theArray = newArray;
        qBegin = 0;
        qEnd = size;
    }
    
    // increments the index of a circular array
    protected int increment(int index) {
        if (++index == theArray.length) index = 0;
        return index;
    }
    
    /** IFF !isEmpty():
     * obtains and removes from a Queue its first Element **/
    // qBegin is incremented according to the behaviour of a circular array
    public E dequeue() {
        E theFirst = theArray[qBegin];
        qBegin = increment(qBegin);
        size--;
        return theFirst;
    }
    
    /** IFF !isEmpty():
     *  obtains the first Element of a Queue,
     *  i.e., first pushed into the Queue **/
    public E first() { return theArray[qBegin]; }
    
    /** checks whether a Queue is empty **/
    public boolean isEmpty() { return size == 0; }
    
   /** returns a String with the Elements of a Queue in FIFO order,
    * or insertion order, and with the format used in the Java standard.
    * Thus, a Queue with Integer elements from 1 to 4 in FIFO order,
    * toString returns [1, 2, 3, 4]; if the Queue is empty, returns []
    */
    // CAREFUL: the circularity of theArray is not only taken into account
    // when using the increment method, but also by counting the number of
    // elements from 0 to size-1
    public String toString() {
        // NOTE: for efficiency reasons, we use
        // StringBuilder instead of String
        StringBuilder res = new StringBuilder();
        res.append("[");
        
        // NOTE: to produce the required format we ...
        // -Traverse the ArrayQueue
        //  from the first to its second-to-last element;
        // -In each element visited,
        //  if aux is the loop's variable in the traversal,
        //  append to res, the output, theArray[aux].toString() + ", "
        int aux = qBegin;
        for (int i = 0, j = size - 1; i < j; i++, aux = increment(aux)){
            res.append(theArray[aux].toString() + ", ");
        }
              
        // NOTE: to produce the required format, after the end
        // of the loop, we add the last element to the output;
        // depending on the size, said element is the String
        // theArray[aux].toString() + "]" or the String "]"
        if (size != 0) res.append(theArray[aux].toString() + "]");
        else res.append("]");
        return res.toString();
    }
}