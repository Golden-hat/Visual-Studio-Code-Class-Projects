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
        ListPOI<E> ret = new LinkedListPOI<>();
        ret.begin();

        while(!pQ1.isEmpty() && !pQ2.isEmpty()){
            E elem1 = pQ1.getMin();
            E elem2 = pQ2.getMin();
            if(elem1.compareTo(elem2) < 0){
                ret.add(elem1);
            }
            else {ret.add(elem2);}
        }

        while(!pQ2.isEmpty()){E elem2 = pQ2.getMin(); ret.add(elem2);}
        while(!pQ1.isEmpty()){E elem1 = pQ2.getMin(); ret.add(elem1);}

        return ret;
    }
    
    /** Exercise 3:
     * Design a static, iterative method pQisLinear. 
     * that determines whether a set of real values conforms (approx.) 
     * to an increasing linear function using the following algorithm: 
     * check whether the difference between any pair of consecutive values, 
     * in ascending order, is bounded by a given epsilon. 
     */
    public static boolean pQisLinear(PriorityQueue<Double> pQ, double epsilon) {
        ListPOI<Double> aux = new LinkedListPOI<>();
        boolean res = true;

        while(!pQ.isEmpty()){ 
            double aux1 = pQ.removeMin(); aux.add(aux1);
            if(pQ.isEmpty()){break;}
            double aux2 = pQ.removeMin(); aux.add(aux2);
            if(Math.abs(aux1-aux2) < epsilon) {res = false; break;};
        }

        aux.begin();
        while(!aux.isEmpty()){pQ.add(aux.get()); aux.next();}
        return res;
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
        PriorityQueue<E> aux = new BinaryHeap<E>();
        PriorityQueue<E> ret = new BinaryHeap<E>();

        for(int i = 0; i < k; i++){
            aux.add(v[i]);
        }
        for(int i = 0; i < k; i++){
            ret.add(aux.removeMin());
        }
        return ret;
    }
    
}