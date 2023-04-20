package examples.topic3;

import libraries.dataStructures.models.Map;
import libraries.dataStructures.scattered.HashTable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Word-by-word bilingual translation of a text.
 * To do this, the class provides two methods:
 * 1.- loadDictionary: creates and returns the Map used in the translation, 
 * reading its entries from the diccioSpaEng.txt file located in eda.
 * 2.- translate: translates the sentence textC word by word using the Map d 
 * When d does not contain the translation for a word of textC, the translation result string must contain the translation result. 
 * String result of translating must contain the literal "<error>" in  
 * instead of its translation
 *      
 * @author (prof EDA) 
 * @version (Course 2022-2023)
 */

public class Test5Map {
    
    public static Map<String, String> loadDictionary() {
        String nDic = "diccioSpaEng.txt";
        Map<String, String> d = new HashTable<String, String>(100);
        try { 
            Scanner ft = new Scanner(new File(nDic), "ISO-8859-1");
            while (ft.hasNextLine()) {
                String line = ft.nextLine();
                String[] a = line.split("\t");
                d.put(a[0], a[1]);
            }
            ft.close();
            return d;
        } catch (FileNotFoundException e) {
            System.out.println("** Error: File not found " + nDic);
            return null;
        }
    }
    
    public static String translate(String textS, Map<String, String> d) {
        String ret = "";
        String[] textSS = textS.split(" +");
        for(int i = 0; i < textSS.length; i++){
            String s = d.get(textSS[i]);
            if(s != null){ret += s;}
            else{ret += "<error>";}
            if(i < textSS.length - 1){ret += " ";}
        }
        return ret;
    }          
}