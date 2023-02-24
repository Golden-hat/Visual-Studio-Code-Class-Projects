package libraries.dataStructures.models;

/**
 * Dictionary Model WITHOUT repeated keys, or Map: Dynamic Search of
 * a given Entry's Key in a Collection, to obtain the Value associated
 * to it
 */
public interface Map<K, V> {

    /** inserts an Entry (k,v) in a Map and returns null;
     * if another Entry with a matching Key k existed before,
     * returns its associated Value and replaces it with v
     * (i.e., updates that Entry with a new value)
     */
    V put(K k, V v);
    
    /** removes the Entry with Key k of a Map and returns its
     * associated value, or null if no Entry exists for the given key
     */
    V remove(K k);
    
    /** returns the value associated to Key k in a Map,
     * or null if no Entry exists for the given key
     */
    V get(K k);
    
    /** checks whether a map is empty */
    boolean isEmpty();
    
    /** returns the size, or number of Entries of a Map */
    int size();
    
    /** returns a ListPOI with the Keys of a Map.
     * The length of the List and the Map are the same. */
    ListPOI<K> keys();
}