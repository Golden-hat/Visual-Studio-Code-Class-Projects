package libraries.dataStructures.models;

/** Represents an Entry of a SortedMap:
 * @param <K>, the type of its keys: any type that implements Comparable. 
 * @param <V>, the type of its values.
 * @version April 2023
 */

public class MapEntry<K extends Comparable<K>, V>  
    implements Comparable<MapEntry<K, V>> {
    
    // An entry of an Sorted Map HAS ONE
    private K key;
    // An entry of a Sorted Map HAS ONE 
    private V value;
   
    /** creates an Entry (c, v) of a Sorted Map */
    public MapEntry(K k, V v) {
        key = k; 
        value = v; 
    }
   
    /** returns the key of an Entry of a Sorted Map */
    public K getKey() { return key; }
   
    /** returns the value of an Entry of an Sorted Map */
    public V getValue() { return value; }
   
    /** updates the key of an Entry of a Sorted Map to new */
    public void setKey(K k) { key = k; }
   
    /** updates to new the value of an Entry of a Sorted Map */
    public void setValue(V v) { value = v; }
    
    /** checks if one Entry is equal to another, 
     * i.e. if their keys are the same */
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        return this.key.equals(((MapEntry<K,V>) other).key);
    }

    /** returns the result of comparing one Entry with another, 
     * i.e. from the comparison of their keys */
    public int compareTo(MapEntry<K, V> another) {
        return key.compareTo(another.key);
    }
   
    /** returns a String representing an Entry of a Sorted Map.
     * with a certain format, i.e. that of the pair formed by its key and value 
     */
    public String toString() { 
        return "(" + this.key + ", " + this.value + ")"; 
    }
}