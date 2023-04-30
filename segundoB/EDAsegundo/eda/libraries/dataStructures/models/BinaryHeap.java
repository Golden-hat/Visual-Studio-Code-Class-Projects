package libraries.dataStructures.models;

import libraries.dataStructures.models.PriorityQueue;

/** BinaryHeap class: represents a Heap with an array,
 *  and stores its Root at index 1.
 *
 *  Its main features are:
 *  @param <E>, the type of its elements, must implement Comparable
 *  ATTRIBUTES (protected so that child classes can see them):
 *      HAS AN array to store the elements (E[] theArray)
 *      HAS A size that stores the number of elements contained
 *      
 * @author (profesores EDA)
 * @version (Curso 2021-2022)
 **/
 
public class BinaryHeap<E extends Comparable<E>>
    implements PriorityQueue<E> {
    
    protected static final int DEFAULT_CAPACITY = 11;
    
    // A Heap is a Complete Binary Tree, and thus,...
    // HAS AN Implicit Representation
    protected E[] theArray;
    // HAS A size or number of nodes
    protected int size;
    
    /** Creates an empty Priority Queue (PQ)
     *  with initial capacity DEFAULT_CAPACITY
     */
    public BinaryHeap() { this(DEFAULT_CAPACITY); }

    /** Creates an empty Priority Queue (PQ)
     * with initial capacity n
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int n) {
        theArray = (E[]) new Comparable[n];
        size = 0;
    }
    
    /** Checks whether a PQ is empty */
    public boolean isEmpty() { return size == 0; }
        
    /** IFF !isEmpty(): gets the datum with the maximum priority in the PQ
     *  @return Element with the highest priority in the PQ
     */
    public E getMin() { return theArray[1]; }
    
    /** Adds the element e to a PQ, taking into account its priority
     *  @param e Element to be added
     */
    public void add(E e) {
        if (size == theArray.length - 1) duplicateArray();
        // STEP 1. Find the ordered insertion position of e
        // (a) Preserve Structural Property
        int pos = ++size; 
        
        // (b) Preserve the Sort Property: swim 
        pos = swim(e, pos); 
        /*
        while (pos > 1 && e.compareTo(theArray[pos / 2]) < 0) { 
            theArray[pos] = theArray[pos / 2]; 
            pos = pos / 2;
        }
        */
        // Insert e at its sorted insertion position
        theArray[pos] = e;
    }
    
    //  @param pos  Position of the element to be swim    
    protected int swim(E e, int pos) {
        while (pos > 1 && e.compareTo(theArray[pos / 2]) < 0) { 
            theArray[pos] = theArray[pos / 2]; 
            pos = pos / 2;
        }
        return pos;
    }
   
    // Duplicates the capacity of theArray
    @SuppressWarnings("unchecked")
    protected void duplicateArray() {
        E[] newArray = (E[]) new Comparable[theArray.length * 2];
        System.arraycopy(theArray, 1, newArray, 1, size);
        theArray = newArray;
    }  
    
    /** IFF !isEmpty(): gets and removes the datum with
     *  the highest priority from the PQ
     *  @return Element with maximum priority of the PQ
     */
    public E removeMin() {
        E theMinimum = theArray[1];
        theArray[1] = theArray[size--];
        sink(1);
        return theMinimum;
    }
    
    //  If necessary, restores the order property of a Heap
    //  by sinking the element of theArray placed
    //  in position pos
    //  @param pos  Position of the element to be sunk
    protected void sink(int pos) {
        int currPos = pos;
        E toSink = theArray[currPos];
        int child = currPos * 2;
        boolean isHeap = false;
        while (child <= size && !isHeap) {
            if (child != size
                && theArray[child + 1].compareTo(theArray[child]) < 0) {
                child++;
            }
            if (theArray[child].compareTo(toSink) < 0) {
                theArray[currPos] = theArray[child];
                currPos = child;
                child = currPos * 2;
            } else { isHeap = true; }
        }
        theArray[currPos] = toSink;
    }
    
    /** returns the number of leaves of a Heap in O(1) */
    public int countLeaves() { 
        return size - (size / 2);
    }
    
    /** returns the maximum of a Heap after size/2 compareTo */
    public E getMax() { 
        int pos = size / 2 + 1;
        E max = theArray[pos];
        while (pos <= size) {
            if (theArray[pos].compareTo(max) > 0) {
                max = theArray[pos];
            } 
            pos++;
        }
        return max;
    }
    
    // to directly add elements at the end of the array
    public void insert(E e) {
        if (size == theArray.length - 1) { duplicateArray(); }
        theArray[++size] = e;
    }
    
    public void arrange() { arrange(1); }
    
    protected void arrange(int i) {
        if (i <= size / 2) { //if not a leaf
            if (2 * i <= size) { arrange(2 * i); }
            if (2 * i + 1 <= size) { arrange(2 * i + 1); } 
            sink(i); 
        }
    }
    
    /* Resets the sort property of a Heap */ 
    // sinks By-Levels and Descending Inner nodes 
    // of theArray, as the Leaves are already Heaps
    public void arrangeIterative() {
        for (int i = size / 2; i > 0; i--) {
            sink(i);
        }
    } 
    
    /** gets a String with the data of a Heap sorted By Levels 
     * and with the format used in the Java standard (between square brackets and separating each element from the previous one with a comma).
     * square brackets and separating each element from the previous one by a comma 
     * followed by a blank space); if the Heap is empty the String 
     * result is []
     */
    public String toString() { 
      // NOTE: the StringBuilder class is used instead of String, 
      // for efficiency reasons
        StringBuilder res = new StringBuilder();
        if (size == 0) return res.append("[]").toString();
        int i = 1;
        res.append("[");
        while (i < size) res.append(theArray[i++] + ", ");
        res.append(theArray[i].toString() + "]"); 
        return res.toString();
    }
    
    public boolean lessThan(E e){
        if(size == 0){return false;}
        return theArray[1].compareTo(e) < 0;
    }
    
    public boolean greaterThan(E e){
        int posIstLeaf = size/2 + 1;
        for(int i = posIstLeaf; i <= size; i++){
            if(theArray[i].compareTo(e) > 0){return true;}
        }
        return false;
    }
}
