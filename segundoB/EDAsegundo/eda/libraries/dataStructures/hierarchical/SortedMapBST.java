package libraries.dataStructures.hierarchical; 

import  libraries.dataStructures.models.SortedMap; 
import  libraries.dataStructures.models.MapEntry; 
import  libraries.dataStructures.models.ListPOI;
import  libraries.dataStructures.linear.LinkedListPOI;
 
/** Class that implements a SortedMap using an BST
  * @param <K>, the class of the SortedMap keys it implements,
  * and which must be Comparable
  * @param <V>, the class of the values of the SortedMap that it implements  
  *             
  */
 
public class SortedMapBST<K extends Comparable<K>, V>    
    implements SortedMap<K, V> {
    
    // An SortedMapBST HAS ONE....
    protected BST<MapEntry<K, V>> bst;
    
    /** creates an empty SortedMap, with size 0 */
    public SortedMapBST() {
        bst = new BST<MapEntry<K, V>>(); 
    }
    
    /** Overwrites Map method: 
     * checks if a Map is empty 
     */
    public boolean isEmpty() { return bst.isEmpty(); }
   
    /** Overwrites Map method: 
     * returns the size, or number of Entries, of a Map. 
     */
    public int size() { return bst.size(); }
    
    /** Overwrites Map method:
     * returns the value associated with the key k in a Map,
     * null if no Entry exists with that key
     */
    public V get(K k) { 
        /* COMPLETE */ 
        // if (e != null) { return e.getValue(); } 
        return null;
    }
   
    /** Overwrites the Map method:
     * insert the Entry (k, v) into a Map and return null; if there already * exists a Key Entry k in a Map and return null; } return null.
     * there is already a Key Entry k in the Map, returns its associated value and substitutes it for 
     * and substitutes it for v (or updates the Entry).
     */
    public V put(K k, V v) {
        /* COMPLETE */ 
        // if (e != null) { return e.getValue(); }
        // else { return null; }
        return null;
    } 
   
    /** Overwrite Map method:
     * removes the Entry with Key k from a Map and returns its * associated value, null if not. 
     * associated value, null if there is no Entry with such key
     */
    public V remove(K k) {
        /* COMPLETE */ 
        // if (e != null) { return e.getValue(); }
        // else { return null; }
        return null;
    } 
   
    /** Overwrites the Map method:
     * returns a ListPOI with the size() Keys of a Map. 
     */
    public ListPOI<K> keys() {
        // ListPOI<MapEntry<K, V>> lpi = bst.toListPOI();
        ListPOI<K> res = new LinkedListPOI<K>();
        /* COMPLETE */ 
        return res;
    } 
    
    // OWN METHODS, BY EFFICIENT, OF A SORTED MAP ****
   
    /** IFF !isEmpty(): gets the minimum KeyEntry of a Map */
    public MapEntry<K, V> getMinEntry() {
        /* COMPLETE */ 
        return null;
    }   

    /** IFF !isEmpty(): gets the minimum Key Entry of a Map */
    public K getMin() {
        /* COMPLETE */
        return null;
    }
   
    /** IFF !isEmpty(): gets the maximum KeyEntry of a Map */
    public MapEntry<K, V> getMaxEntry() {
        /* COMPLETE */ 
        return null;
    }   

    /** IFF !isEmpty(): gets the maximum Key Entry of a Map */
    public K getMax() {
        /* COMPLETE */ 
        return null;
    }
    
    /** IFF !isEmpty(): gets the next Entry to k
     * according to the established order between keys, null if it does not exist */
    public MapEntry<K, V> successorEntry(K k) {
        /* COMPLETE */ 
        return null;
    }
    
    /** IFF !isEmpty(): gets the Key following k
     * according to the established order between keys, null if it does not exist */
    public K successor(K k) {
        /* COMPLETE */
        return null;
    }
    
    /** IFF !isEmpty(): gets the Entry before ck
     * according to the order established between keys, null if it does not exist */
    public MapEntry<K, V> predecessorEntry(K k) {
        /* COMPLETE */ 
        return null;
    }
    
    /** IFF !isEmpty(): gets the key before k
     * according to the established order between keys, null if it does not exist */
    public K predecessor(K k) {
        /* COMPLETE */ 
        return null;
    }
   
    /** IFF !isEmpty(): 
     * removes and returns the minimum KeyEntry of a Sorted Map */
    public MapEntry<K, V> removeMinEntry() {
        /* COMPLETE */ 
        return null;
    }
   
    /** IFF !isEmpty(): 
     * removes and returns the minimum Key of a Sorted Map */
    public K removeMin() {
        /* COMPLETE */ 
        return null;
    }

}