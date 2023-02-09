package examples.topic1;

import libraries.dataStructures.models.List;
import libraries.dataStructures.linear.LinkedList;

public class TestShoppingList {
    public static void main(String[] args) {

        List<String> l = new LinkedList<String>();
   
        l.add("patatas", l.size());
        l.add("cerezas", l.size());
        l.add("leche", l.size());
        System.out.println("My shopping list is:\n" + l.toString());
        
        System.out.println("Have I forgotten to add perejil?");
        // Sequential search for "perejil" in the list, if
        // it does not exist, it is added at the list's end
        int i = 0;
        while (i < l.size() && !l.get(i).equals("perejil")) i++;
        if (i == l.size()) l.add("perejil", l.size());
        System.out.println("Added perejil in the " + i + "th place");
    }
}