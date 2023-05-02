package libraries.dataStructures.models;

/**
 * Ordered Dictionary Model WITHOUT repeated keys, or Ordered Map:  
 * Dynamic Lookup of a given Key Entry, to get the associated 
 * Value associated with it. 
 * @param <K>, the type of its keys.
 * @param <V>, the type of its values.
 * @version April 2023
 */

public interface SortedMap<K extends Comparable<K>, V> extends Map<K, V> {
    // EXTENDING AN INTERFACE IN ANOTHER INTERFACE DOES NOT REQUIRE THE IMPLEMENTATION OF ITS METHODS
    /** IFF !isEmpty(): 
     * gets the minimum Key Entry of a Sorted Map */
    MapEntry<K, V> getMinEntry();
    /** IFF !isEmpty(): gets the Minimum Key Entry of a Sorted Map */
    K getMin();   
   
    /** IFF !isEmpty(): 
     * gets the maximum Key Input of a Sorted Map */
    MapEntry<K, V> getMaxEntry();
    /** IFF !isEmpty(): gets the maximum Key Entry of a Sorted Map */
    K getMax(); 

    /** IFF !isEmpty(): gets the next Entry to k
     * according to the established order between keys */
    MapEntry<K, V> successorEntry(K k);  
    /** IFF !isEmpty(): gets the key following k
     * according to the established order between keys */
    K successor(K k); 
    
    /** IFF !isEmpty(): gets the Entry before k
     * according to the established order between keys */
    MapEntry<K, V> predecessorEntry(K k);  
    /** IFF !isEmpty(): gets the key before k
     * according to the established order between keys */
    K predecessor(K k); 
    
    /** IFF !isEmpty(): 
     * removes and returns the minimum Key Entry of an Ordered Map */
    MapEntry<K, V> removeMinEntry();
    /** IFF !isEmpty(): 
     * removes and returns the minimum Key of a Sorted Map */
    K removeMin();
}