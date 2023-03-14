package libraries.dataStructures.scattered;

import libraries.dataStructures.models.Map;
import libraries.dataStructures.models.ListPOI;
import libraries.dataStructures.linear.LinkedListPOI;

/**
 * HashTable: implementation of a Linked Hash Table
 * whose buckets, or collision lists, are represented
 * through Lists with POI of HashEntry<K,V>.
 * 
 * @param <K>  the keys' type in the Map
 * @param <V>  the values' type in the Map
 * 
 * @author (EDA-QA) 
 * @version (Curso 2020-2021)
 */

public class HashTable<K, V> implements Map<K, V> {

    // A Hash Table HAS:

    // A JAVA CONSTANT that represents...
    /** The default value (float) of the standard load factor (by default)
     *  of a Hash Table (the same as the one used in java.util.HashMap) */
    public static final double LF_STANDARD = 0.75;

    // AN array of ListPOIs whose elements are HashEntry<K,V>:
    // - theArray[h] represents a bucket, or list of
    //   collissions associated to the Hash index h
    // - theArray[h] contains the reference to the ListPOI
    //   that contains all Entries whose Key has Hash index h.
    protected ListPOI<HashEntry<K, V>>[] theArray;

    // A size that represents the number of Entries
    // stored in a Hash Table, or (specifically) in its buckets.
    protected int size;

    // A method hashIndex that represents the dispersion
    // function of the table
    // **WITHOUT THIS METHOD, THE HASH TABLE IS JUST AN ARRAY**
    /**
     * Returns the hash index of a given Entry's Key k,
     * i.e. the index of the bucket in which the Entry should
     * be placed.
     */
    protected int hashIndex(K k) {
        int hashIndex = k.hashCode() % this.theArray.length;
        if (hashIndex < 0) { hashIndex += this.theArray.length; }
        return hashIndex;
    }

    /** Creates an empty HashTable, with estimatedMaxSize
     *  entries and load factor 0.75 */
    @SuppressWarnings("unchecked")
    public HashTable(int estimatedMaxSize) {
        int capacity = (int) (estimatedMaxSize / LF_STANDARD);
        capacity = nextPrime(capacity);
        theArray = new LinkedListPOI[capacity];
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = new LinkedListPOI<HashEntry<K, V>>();
        }
        size = 0;
    }

    /**
     * Returns a prime number GREATER or EQUAL to n,
     * i.e. the first prime after n. */
    public static int nextPrime(int n) {
        int aux = n;
        if (aux % 2 == 0) { aux++; }
        for (; !isPrime(aux); aux += 2) { ; }
        return aux;
    }

    /** Checks whether n is a prime number */
    protected static boolean isPrime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false; // n ISN'T prime
        }
        return true; // n IS prime
    }

    /** Returns the (real) load factor of a Hash Table,
     *  which is equivalent to the average length of its
     *  buckets in a Linked implementation of the Table */
    public final double loadFactor() {
        return (double) size / this.theArray.length;
    }

    /** Checks whether a Hash Table is empty,
     *  i.e. if it has 0 Entries */
    public boolean isEmpty() { return size == 0; }

    /** Returns the size, or number of Entries of a Hash Table. */
    public int size() { return size; }

    /** Returns a ListPOI with the size() keys of a Hash Table */
    public ListPOI<K> keys() {
        ListPOI<K> res = new LinkedListPOI<K>();
        for(int i = 0; i < theArray.length; i++){
            
        }
        
        return res;
    }

    /** Returns the value of the Entry with Key k of a
     *  Hash Table, or null if no such entry exists in the Table */
    public V get(K k) {
        int pos = hashIndex(k);
        ListPOI<HashEntry<K, V>> l = theArray[pos];
        V value = null;
        
        l.begin();
        while(!l.isEnd() && !l.get().key.equals(k)){
            l.next();
        }
        
        if(!l.isEnd()){
            value = l.get().value;
        }
        return value;
    }

    /** Removes the Entry with Key k from a Hash Table and
     *  returns its associated value, or null if that entry
     *  does not appear in the Table */
    public V remove(K k) {
        int pos = hashIndex(k);
        ListPOI<HashEntry<K, V>> l = theArray[pos];
        V value = null;
        // COMPLETE
        
        return value;
    }

    /** Inserts the Entry(k, v) in a Hash Table and
     *  returns the old value associated to k, or null
     *  if no old entry existed in the Table */
    public V put(K k, V v) {
        int pos = hashIndex(k);
        ListPOI<HashEntry<K, V>> l = theArray[hashIndex(k)];
        V oldValue = null;
        // COMPLETE
        
        return oldValue;
    }
    
    /** Returns a String with the Entries of a Hash Table
     *  in a given text format (see HashEntry#toString()) */
    // REMEMBER: use StringBuilder to be efficient
    public final String toString() {
        StringBuilder res = new StringBuilder();
        // COMPLETE
        
        return res.toString();
    }
}
