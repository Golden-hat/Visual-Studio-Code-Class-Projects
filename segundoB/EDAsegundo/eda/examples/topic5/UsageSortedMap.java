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
        // COMPLETE
		
		return null;
    }
    
    /** Design a static, generic, iterative mapSort method 
     * that, with the help of a SortedMap, 
     * sorts the (Comparable) elements of a non-empty, non-repeated array v.  
     */
    public static <C extends Comparable<C>> void mapSort(C[] v) {
        // COMPLETE
		
    }
    
    /** Design a static, iterative method 2ThatSum 
     * that, given a non-empty array v of integers and an integer k, 
     * determine whether there exist in v two numbers whose sum is k. 
     * Use an SortedMap as an auxiliary EDA.
     */
    public static boolean 2ThatSum(int[] v, int k) {
        // CI¡OMPLETE
        return false;
    }
}