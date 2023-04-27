package examples.topic5;

import libraries.dataStructures.models.SortedMap;
import libraries.dataStructures.models.MapEntry;
import libraries.dataStructures.models.ListPOI; 
import libraries.dataStructures.linear.LinkedListPOI; 
import libraries.dataStructures.hierarchical.SortedMapBST;

/**
 * class UsageSortedMap.
 * 
 * @author FTG 
 * @version 2.0
 */

public class UsageSortedMap {
    
    /** Design a static, generic, iterative method entries 
     * that returns a ListPOI with the Entries of a non-empty Map m, 
     * sorted in ascending order. 
     */
    public static <K extends Comparable<K>, V> 
    ListPOI<MapEntry<K, V>> entries(SortedMap<K, V> m) 
    {
        ListPOI<MapEntry<K,V>> l  = new LinkedListPOI<>();
        MapEntry<K,V> e = m.getMinEntry();

        l.add(e);
        for(int i = 2; i <= m.size(); i++){
            e = m.successorEntry(e.getKey());
            l.add(e);
        }
        return l;
    }
    
    /** Design a static, generic, iterative mapSort method 
     * that, with the help of a SortedMap, 
     * sorts the (Comparable) elements of a non-empty, non-repeated array v.  
     */
    public static <K extends Comparable<K>> void mapSort(K[] v) {
        SortedMap<K,K> m = new SortedMapBST<K,K>();
        
        for(int i = 0; i < v.length; i++){
            m.put(v[i], v[i]);
        }
        
        K k = m.getMin();
        v[0] = k;
        for(int i = 1; i < v.length; i++){
            k = m.successor(k);
            v[i] = k;
        }
    }
    
    /** Design a static, iterative method 2ThatSum 
     * that, given a non-empty array v of integers and an integer k, 
     * determine whether there exist in v two numbers whose sum is k. 
     * Use an SortedMap as an auxiliary EDA.
     */
    public static boolean TwoThatSum(int[] v, int k) {
        SortedMap<Integer,Integer> m = new SortedMapBST<>();

        for(int i = 0; i < v.length; i++){
            m.put(v[i], i);
        }

        for(int i = 0; i < v.length; i++){
            int aux = m.getMin();
            while(aux != m.getMax()){
                if(v[0] + aux == k){return true;}
                aux = m.successor(aux);
            }
        }
        return false;
    
        /*Alternate solution.
         * 
         * Integer min = m.getMin();
         * Integer max = m.getMax();
         * 
         *      for(int i = 0; i < v.length-1; i++){
         *          int sum = min + max;
         *          if (sum == k) {return true;}
         *          if (sum > k) {min = m.successor(min);}
         *          else {max = m.predecessor(max);}
         *     }
         *  
         * return false;
         * 
         */
    }
}