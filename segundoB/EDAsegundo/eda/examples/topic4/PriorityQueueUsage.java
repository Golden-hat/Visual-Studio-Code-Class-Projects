package examples.topic4;

import libraries.dataStructures.models.PriorityQueue;
import libraries.dataStructures.hierarchical.BinaryHeap;
import libraries.dataStructures.models.ListPOI;
import libraries.dataStructures.linear.LinkedListPOI;

/**
 * class PriorityQueueUsage.
 * 
 * @author EDA 
 * @version 1.0
 */

public class PriorityQueueUsage {
    
    /** Exercise 1: 
     * Design a static, iterative method pQSort. 
     * that, with the help of a Priority Queue, 
     * sort an array v of Comparable elements. 
     */
    public static <E extends Comparable<E>> void pQSort(E[] v) {
        PriorityQueue<E> x = new BinaryHeap<E>(v.length + 1);
        for(int i = 0; i < v.length; i++  ){
            x.add(v[i]);
        }
            
        for(int i = 0; i < v.length; i++){
            v[i] = x.removeMin();
        }
    }
    
    /** Exercise 2:
     * Design a static, generic, iterative method pQMerge. 
     * that returns a ListPOI with the data from 2 given Priority Queues, 
     * pQ1 and pQ2, sorted in ascending order. 
     * The method cannot use any auxiliary EDA to compute its result. 
     * and, moreover, pQ1 and pQ2 must be empty at the end of its execution.
     */
    public static <E extends Comparable<E>> ListPOI<E> pQMerge(
        PriorityQueue<E> pQ1, PriorityQueue<E> pQ2) 
    {
        // COMPLETE
        return null;
    }
    
    /** Exercise 3:
     * Design a static, iterative method pQisLinear. 
     * that determines whether a set of real values conforms (approx.) 
     * to an increasing linear function using the following algorithm: 
     * check whether the difference between any pair of consecutive values, 
     * in ascending order, is bounded by a given epsilon. 
     */
    public static boolean pQisLinear(PriorityQueue<Double> pQ, double epsilon) {
        // COMPLETE
        return false;
    }
    
    /** Exercise 4:
     * Design a static, generic, iterative method pQTopK. 
     * that, given an array of data v and an integer k, 
     * returns a Priority Queue with the k best (Top K) data from v. 
     * The method must have a cost O(N log k), where N is the length of v.
     */
    public static <E extends Comparable<E>> PriorityQueue<E> pQTopK(
        E[] v, int k) 
    {
        // COMPLETE
        return null;
    }
    
}