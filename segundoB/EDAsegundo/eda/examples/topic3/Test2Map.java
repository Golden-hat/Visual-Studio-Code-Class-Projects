package examples.topic3;
// Design a new Test2Map program that reads a text from the keyboard and
// displays on the screen the number of different words it contains

//to use Map and ListPOI
import libraries.dataStructures.models.*; 

//to use HashTable the Map implementation
import libraries.dataStructures.scattered.*; 

import java.util.Locale; 
import java.util.Scanner; 

public class Test2Map {
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
        Map<String, String> m = new HashTable<String, String>(text.length());

        // Construction of the Map, via insertion/updating of its entries, 
        // from the text read: 
        // use of String split method with separator " " (one or more).
        String[] textWords = text.split(" +");
        for (int i = 0; i < textWords.length; i++) 
            // NOTE: THE CHEAPEST WOULD BE 
            // m.put(textWords[i].toLowerCase(), 
            // textWords[i].toLowerCase());
            m.put(textWords[i].toLowerCase(), ""); 
        
        // we are asked ONLY for the number of different words
        System.out.println("Number of different words, " + "or size of the Map " + m.size());
    } 
}
