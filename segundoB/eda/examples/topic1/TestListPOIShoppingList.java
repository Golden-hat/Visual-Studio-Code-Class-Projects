package examples.topic1;

import libraries.dataStructures.models.ListPOI;
import libraries.dataStructures.linear.LinkedListPOI;

public class TestListPOIShoppingList {
    public static void main(String[] args){
     
        ListPOI<String> l = new LinkedListPOI<String>();
        
        /*l.begin();*/

        l.add("patatas"/*, l.size()*/);
        l.add("cerezas"/*, l.size()*/);
        l.add("leche"/*, l.size()*/);
        System.out.println("My shopping list is:\n" + l.toString());
        
        System.out.println("Have I forgotten to write down perejil?");
        // Sequential search for "perejil" in the list, such that if
        // not found, it is added at the end of the list.
        
        l.begin(); String e = "perejil";
        while (!l.isEnd() && !l.get().equals(e)) l.next();
        if (l.isEnd()) {

            // CHANGE 1: add "perejil"
            // at the beginning of the list instead of at the end:
            l.begin();

            l.add(e/*, l.size()*/);
            System.out.println("Well, I was right. "
                + "I'm writing it down at the beginning of the list, fixed:\n"
                + l.toString());
        }
        else System.out.println("I was wrong, it already was in the list!");

        // CHANGE 2: add "perejil" before "cerezas"
        // Previous step: remove it from the list, it is at the beginning of it
        l.begin(); l.remove();
        System.out.println("Removing perejil from the start of the list:\n"+l.toString());
        // Now we add it just before "cerezas":
        // we move the POI to cerezas and insert it
        l.begin();
        while(!l.isEnd() && !l.get().equals("cerezas")) l.next();
        if (!l.isEnd()) {
            l.add(e);
            System.out.println("Writing perejil down just before cerezas:\n"
                + l.toString());
        }
        else {
            l.add(e);
            System.out.println("There are no cerezas en la lista!"
                + "Writing perejil at the end:\n"
                + l.toString());
        }
    }
}