package applications.primitiva;

import libraries.dataStructures.models.ListPOI;
import libraries.dataStructures.linear.LinkedListPOI;
import libraries.dataStructures.linear.SortedLinkedListPOI;

/** 
 * PrimitivaBet: represents a random bet in La Primitiva, a
 * combination of 6 different numbers between 1 and 49 chosen
 * randomly.
 * 
 * @version February 2019
 */

public class PrimitivaBet {
    // La Primitiva HAS A List with POI that holds
    // a combination of 6 Primitiva numbers
    private ListPOI<PrimitivaNumber> combination;
    
    /**
     * Creates a PrimitivaBet, a combination of six
     * random and distinct numbers in the range [1, 49].
     * 
     * @param sorted A boolean that indicates whether the
     *               combination (its 6 numbers) must be sorted
     *               in ascending order (true) or not (false).
     */
    public PrimitivaBet(boolean sorted) {
        if(sorted){combination = new SortedLinkedListPOI<PrimitivaNumber>();}
        else{combination = new LinkedListPOI<PrimitivaNumber>();}
        
        while(combination.size() < 6){
            PrimitivaNumber n = new PrimitivaNumber();
            if(indexOf(n) == -1) {combination.add(n);}
        }
    }
    
    /**
     * Returns the position or index of a number n in a PrimitiveBet,
     * or -1 if n does not appear in the combination.
     * IMPORTANT: we assume that the first element in a combination
     * has index 0, and the last, index 5.
     * 
     * @param n a number
     * @return  the index of n in a combination, an integer value
     *          in the interval [0, 5] if n exists in the combination,
     *          or -1 otherwise
     */
    protected int indexOf(PrimitivaNumber n) {
        combination.begin();
        for(int i = 0; i < combination.size(); i++){
            if(n.equals(combination.get())){return i;}
            combination.next();
        }
        return -1;
    }
    
    /**
     * Returns a String that represents a PrimitivaBet in the text format
     * shown in the following example: "16, 25, 28, 49, 9, 20".
     * 
     * @return the String with the PrimitivaBet in the specified format.
     */
    public String toString() {
        combination.begin();
        String s = combination.get().toString();
        combination.next();
        while(!combination.isEnd()){
            s += ", "+combination.get().toString();
            combination.next();
        }
        return s;
    }
}
