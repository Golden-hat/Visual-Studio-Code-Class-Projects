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

    // A JAVA CONSTANT that represents...
    /** The (boolean) value that indicates whether a Hash Table
     *  performs REHASHING when its load factor exceeds LF_STANDARD */
    public static final boolean REHASHING = true;  // in Part 2 it must be true;

    // AN array of ListPOIs whose elements are HashEntry<K,V>:
    // - theArray[h] represents a bucket, or list of
    //   collissions associated to the Hash index h
    // - theArray[h] contains the reference to the ListPOI
    //   that contains all Entries whose Key has Hash index h.
    protected ListPOI<HashEntry<K, V>>[] theArray;

    // A size that represents the number of Entries
    // stored in a Hash Table, or (specifically) in its buckets.
    protected int size;

    // A number of rehashing operations (int) performed
    // to improve the average lookup cost of a Key in
    // its 'size' Entries.
    private int rhCount;

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
        rhCount = 0;
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
        return (double) size / theArray.length;
    }

    /** Checks whether a Hash Table is empty,
     *  i.e. if it has 0 Entries */
    public boolean isEmpty() { return size == 0; }

    /** Returns the size, or number of Entries of a Hash Table. */
    public int size() { return size; }

    /** Returns the number of Rehashing operations that
     *  have been performed during the Hash Table operation */
    public int numberOfRehashings() { return rhCount; }

    /** Returns a ListPOI with the size() keys of a Hash Table */
    public ListPOI<K> keys() {
        ListPOI<K> res = new LinkedListPOI<K>();
        for (int i = 0; i < theArray.length; i++) {
            ListPOI<HashEntry<K, V>> l = theArray[i];
            for (l.begin(); !l.isEnd(); l.next()) {
                HashEntry<K, V> e = l.get();
                res.add(e.key);
            }
        }
        return res;
    }

    /** Returns a String with the Entries of a Hash Table
     *  in a given text format (see HashEntry#toString()) */
    // REMEMBER: use StringBuilder to be efficient
    public final String toString() {
        StringBuilder res = new StringBuilder();
        for (ListPOI<HashEntry<K, V>> l : theArray) {
            for (l.begin(); !l.isEnd(); l.next()) {
                res.append(l.get()).append("\n");
            }
        }
        return res.toString();
    }

    /** Returns the value of the Entry with Key k of a
     *  Hash Table, or null if no such entry exists in the Table */
    public V get(K k) {
        int pos = hashIndex(k);
        ListPOI<HashEntry<K, V>> l = theArray[pos];
        V value = null;
        // Searching for the Entry with Key k in bucket l
        l.begin();
        while (!l.isEnd() && !l.get().key.equals(k)) {
            l.next();
        }
        // Wrapping up the Search: IFF it is found,
        // we obtain the value of that Entry
        if (!l.isEnd()) { value = l.get().value; }
        return value;
    }

    /** Removes the Entry with Key k from a Hash Table and
     *  returns its associated value, or null if that entry
     *  does not appear in the Table */
    public V remove(K k) {
        int pos = hashIndex(k);
        ListPOI<HashEntry<K, V>> l = theArray[pos];
        V value = null;
        // Searching for the Entry with Key k in bucket l
        l.begin();
        while (!l.isEnd() && !l.get().key.equals(k)) {
            l.next();
        }
        // Wrapping up the Search: IFF it is found,
        // recover the entry's value and then, remove it from l
        if (!l.isEnd()) {
            value = l.get().value;
            l.remove();
            size--;
        }
        return value;
    }

    /** Inserts the Entry(k, v) in a Hash Table and
     *  returns the old value associated to k, or null
     *  if no old entry existed in the Table */
    // Invokes method rehashing() IFF
    // - The constant REHASHING's value is true
    // AND
    // - AFTER inserting a new Entry in its corresponding
    //   bucket and incrementing the size of the Table,
    //   loadFactor() > LF_STANDARD
    public V put(K k, V v) {
        ListPOI<HashEntry<K, V>> l = theArray[hashIndex(k)];
        V oldValue = null;
        // Searching for the Entry with Key k in bucket l
        l.begin();
        while (!l.isEnd() && !l.get().key.equals(k)) {
            l.next();
        }
        // Wrapping up the Search: if the Entry (k, v) ISN'T
        // in the Table, it is inserted at the end of bucket l,
        // the size is incremented, and (if applicable), the
        // table is rehashed. Otherwise, when the Entry already
        // is in l, its value is updated.
        if (l.isEnd()) {
            // Effective insertion of the Entry (k, v)
            l.add(new HashEntry<K, V>(k, v));
            size++;
            
            if (loadFactor() > LF_STANDARD && REHASHING) {
                rhCount++;
                rehashing(); 
            }
        }
        else {
            // Obtain the current value of the Entry with
            // Key k, to return it, and update it to the new value v
            oldValue = l.get().value;
            l.get().value = v;
        }
        return oldValue;
    }

    /** Method that implements Rehashing. For obvious reasons,
     *  rhCount MUSTN'T be re-initialized. */
    @SuppressWarnings("unchecked")
    protected final void rehashing() {
        /* Cuando hacemos rehashing, lo que estamos haciendo es
           crear un nuevo HashMap con el doble del tamaño para
           volcar el contenido de las Listas en nuevos espacios
           del mapa.
           
           Para ello, creamos un nuevo hashMap con dichas condiciones
           (se busca el primer numero primo despues del numero duplicado
           por conveniencia), y CREAREMOS UNA VARIABLE AUXILIAR RESPONSABLE
           DE COPIAR NUESTRO theArray EXISTENTE */
        ListPOI<HashEntry<K,V>>[] aux = theArray;
        theArray = new LinkedListPOI[nextPrime(theArray.length*2)];
        
        /* Tendremos que inicializar las listas linkeadas en cada slot de theArray */
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = new LinkedListPOI<>();
        }
    
        /* Ahora, pasaremos los elementos de aux (recordemos que es igual que el theArray
           previo), al nuevo theArray.
           
           Para ello, recurrimos a un bucle for doble, que accede primero a los slots de aux
           utilizando un objeto auxiliar llamado list, y luego, accede a cada elemento de 
           esa lista utilizando los metodos de las listas enlazadas con punto de interes */
        for(ListPOI<HashEntry<K,V>> list:aux){
            for(list.begin(); !list.isEnd(); list.next()){
                
                /* Se recurre a un objeto auxiliar elem para almacenar el elemento de la lista que
                   esta siendo procesado.
                   
                   Posteriormente, este objeto se almacena en el nuevo array invocando la funcion 
                   hashIndex, que devuelve el indice correspondiente al objeto segun su hashValue,
                   e invocando tambien el elemento add, que finalmente añade a theArray un nuevo 
                   hashEntry con los mismos valores que elem*/
                HashEntry<K,V> elem = (list.get());
                theArray[hashIndex(elem.key)].add(new HashEntry<>(elem.key, elem.value));
                //theArray[hashIndex(elem.key)].add(elem); Seria equivalente!
            }
        }
    }

    // Methods to analyze the efficiency of a Linked Hash Table

    /** Returns the standard deviation of the bucket sizes
     *  in a Linked Hash Table */
    public final double standardDeviation() {
        double ret = 0.0;
        double avg = loadFactor();
        for(int i = 0; i < theArray.length; i++){
            ret += (theArray[i].size() - avg)*(theArray[i].size() - avg);
        }
        return Math.sqrt(ret/theArray.length);
    }

    /** Returns the average cost to locate a key of
     *  a Linked Hash Table, computed based on the
     *  number of collisions produced when locating
     *  its 'size' keys.
     */
    public final double avgLookUpCost() {
        double res = 0.0;
        /* El numero de colisiones viene dado por la longitud
           de una lista dentro del hash map. Para obtener el
           tiempo medio de acceso hay que contar todas las
           colisiones de todas las listas (es decir, el numero
           de elementos en cada lista) y dividirlas por el size. */
        for(ListPOI<HashEntry<K, V>> cub : theArray){
            res += (cub.size()*(cub.size()-1))/2;
        }
        return res/this.size();
    }

    /** Returns a String with the occupation histogram
     *  of a Linked Hash Table in textual format. Thus,
     *  each of its two lines show two integer values
     *  separated by a tab: the bucket length (int in [0, 9])
     *  and the number of buckets with that length.
     *  ATTENTION: the number of buckets in each line i IS:
     *  (a) 0 <= i <= 8: the number of buckets in the Table
     *      with exactly i elements (size == i)
     *  (b) i == 9 (last line): the number of buckets in the
     *      Table that contain 9 or more elements.
     */
    public String histogram() {
        int[] histo = new int[10];
        for (int i = 0; i < theArray.length; i++) {
            int bucketLength = theArray[i].size(); //CAREFUL! NOT a traversal!
            if (bucketLength < 9) { histo[bucketLength]++; }
            else { histo[9]++; }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < histo.length; i++) {
            res.append(i).append('\t').append(histo[i]).append('\n');
        }
        return res.toString();
    }

    public Map<K, Integer> locateCostMap() {
        Map<K, Integer> map = new HashTable<>(size);
        for (ListPOI<HashEntry<K,V>> list : theArray) {
            int i = 1;
            for (list.begin(); !list.isEnd(); list.next())
                map.put(list.get().key, i++);
        }
        return map;
    }
}
