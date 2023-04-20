package examples.topic3;

import libraries.dataStructures.models.*; 
import libraries.dataStructures.linear.*; 
import libraries.dataStructures.scattered.*; 

public class TestUnion {

    class Pair<E> {
        E data; int frec;
        Pair(E d, int f) { data = d; frec = f; }
        public String toString() {
        return data.toString()+"-"+frec+" ";
        }
    }

    public static <E> String union(ListPOI<E> l1, ListPOI<E> l2) {
        ListPOI<Pair> aux = new LinkedListPOI<Pair>();
        for (l1.begin(); !l1.isEnd(); l1.next()) {
            E e = l1.get();
            for (aux.begin(); !aux.isEnd() && !e.equals(aux.get().data); aux.next());
            if (aux.isEnd()) { aux.add(new Pair(e,1)); } 
            else { aux.get().frec++; }
        }
        for (l2.begin(); !l2.isEnd(); l2.next()) {
            E e = l2.get();
            for (aux.begin(); !aux.isEnd() && !e.equals(aux.get().data); aux.next());
            if (aux.isEnd()) { aux.add(new Pair(e, 1)); }
            else { aux.get().frec++; }
        }
        return aux.toString();
    }
    
    public static <E> String unionMap(ListPOI<E> l1, ListPOI<E> l2) {
        Map<E, Integer> map = new HashTable<E, Integer>(l1.size() + l2.size());
        for (l1.begin(); !l1.isEnd(); l1.next()) {
            E e = l1.get();
            Integer key = map.get(e);
            if (key == null) { map.put(e, 1); } 
            else { map.put(e,key++); }
        }
        for (l2.begin(); !l2.isEnd(); l2.next()) {
            E e = l2.get();
            Integer key = map.get(e);
            if (key == null) { map.put(e, 1); } 
            else { map.put(e,key++); }
        }
        return map.toString();
    }
}