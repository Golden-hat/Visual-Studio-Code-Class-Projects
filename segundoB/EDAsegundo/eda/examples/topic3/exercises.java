package examples.topic3;

import libraries.dataStructures.linear.LinkedListPOI;
import libraries.dataStructures.models.*; 
//to use HashTable the Map implementation
import libraries.dataStructures.scattered.*; 

public class exercises {

    /**
     * Returns the mode of
     * a given generic array
     * implementing a map
     * @return 
     */
    public static <E> E mode(E[] array){
        Map<E, Integer> map = new HashTable<E, Integer>(array.length);
        E modeV = null;
        int frecMode = 0;
        for(int i = 0; i < array.length; i++){
            Integer e = map.get(array[i]);
            if(e == null){
                map.put(array[i], 1);
            }
            else{map.put(array[i], e++);}

            if(frecMode < e){
                frecMode = e;
                modeV = array[i];
            }
        }
        return modeV;
    }
    /** We have two Map<Key,Value> m1 and m2 implemented with two Hash Tables. Design a
     * static method difference that returns the difference Map of m1 and m2, i.e. a Map that
     * contains only those Entries of m1 that are not in m2.
     * 
     * Note that only the methods defined in the Map interface and the constructor method of
     * HashTable can be used.
     */
    public <K, V> Map<K, V> diffMaps(Map<K, V> map1, Map<K, V> map2){
        Map<K, V> map = new HashTable<K, V>(map1.size() + map2.size());

        ListPOI<K> keys = map2.keys();

        keys.begin();
        while(!keys.isEnd()){
            V value = map1.get(keys.get());
            if(value == null){
                map.put(keys.get(), value);
            }
            keys.next();
        }
        return map;
    }
}
