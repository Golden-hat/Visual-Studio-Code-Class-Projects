package examples.topic3;

// Design a new Test3Map program that reads a text from the keyboard and
// displays on the screen a list in which each line contains a repeated word
// from the text (that has appeared more than once in it) and the number of
// times it is repeated in it (its frequency of occurrence).

//to use Map and ListPOI
import libraries.dataStructures.models.*; 

//to use HashTable the Map implementation
import libraries.dataStructures.scattered.*;

import java.util.Locale; 
import java.util.Scanner; 

public class Test3Map {
    public static void main(String[] args) {
        
        // For simplicity, the text is not read from a file,  
        // but is read from the keyboard as a String of words separated by blanks. 
        // An example String would be: 
        // "OK, even though it's a bit of a mouthful, I'm doing it to show you how Map works! I forgot to write repeated words!!!"

        // Reading of the text (String) from which the Map is constructed.
        Locale localEDA = new Locale("es", "US");
        Scanner keyboard = new Scanner(System.in).useLocale(localEDA);
        System.out.println("Write words separated by blanks:");
        String text = keyboard.nextLine();

        // Creating the empty Map ... 
        // What Key and Value does each Entry of this Map have? 
        // What types are they? 
        Map<String, Integer> m = new HashTable<String, Integer>(text.length());

        // Construction of the Map, via insertion/updating of its entries, 
        // from the text read: 
        // use of String split method with separator " " (one or more).
        String[] textWords = text.split(" +");
        for (int i = 0; i < textWords.length; i++){
            String word = textWords[i].toLowerCase();
            Integer n = m.get(word);
            if(n == null){
                m.put(word, 1);
            }
            else{m.put(word, n+1);}
        }
        
        /* TO PRINT */
        ListPOI<String> keySet = m.keys();
        /* Sacas todas las keys del mapa, con las cuales
         * vas accediendo a las veces que cada una se ha
         * repetido. RECORDEMOS QUE LAS KEYS SON LAS PALABRAS
         */
        keySet.begin();
        while(!keySet.isEnd()){
            /* Como el set de llaves es un objeto lista
             * se atraviesa este utilizando sus métodos
             * propios.
             */
            System.out.println(keySet.get());
            String word = keySet.get();
            /* Se obtiene la palabra en cuestión
             * mediante el método get() sobre la key 
             * en el punto de interés.
             */
            Integer counter = m.get(word);
            /* un counter se encarga de referenciar el número
            de repeticiones asociada a la palabra */
            if(counter >= 2)
                System.out.println("The String "+ word +" has appeared "+counter+" times.");
            keySet.next();
        }
    } 

     /* PRINT ONLY HIGHER FREQUENCY THAN */
     public static  <K, V> void higherFrequencyThan(Map<String, Integer> map, int n){
        
        Map<String, Integer> auxMap = new HashTable<String, Integer>(map.size());
        ListPOI<String>keySet = auxMap.keys();

        while(!keySet.isEnd()){
            /* Como el set de llaves es un objeto lista
             * se atraviesa este utilizando sus métodos
             * propios.
             */
            System.out.println(keySet.get());
            String word = keySet.get();
            /* Se obtiene la palabra en cuestión
             * mediante el método get() sobre la key 
             * en el punto de interés.
             */
            Integer counter = auxMap.get(word);
            /* un counter se encarga de referenciar el número
            de repeticiones asociada a la palabra */
            if(counter >= n)
                System.out.println("The String "+ word +" has appeared "+counter+" times.");
            keySet.next();
        }
    }
}
