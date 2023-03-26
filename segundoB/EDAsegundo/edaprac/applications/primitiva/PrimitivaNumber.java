package applications.primitiva;

import java.util.Random;

/** PrimitivaNumber: represents an integer number
 *  between 1 and 49, chosen randomly.
 *
 *  @version February 2019
 */

public class PrimitivaNumber implements Comparable<PrimitivaNumber>{
    
    private int number;
    
    /**
     * Creates a PrimitivaNumber by choosing randomly
     * a number in the integer range [1, 49].
     */
    public PrimitivaNumber() {
        Random r = new Random();
        number = r.nextInt(49) + 1;
    }
    
    /**
     * Checks whether a (this) PrimitivaNumber is equal to another,
     * i.e. if both hold the same value
     * 
     * @param other the other PrimitivaNumber.
     * @return true if this and other hold the same value,
     *              false otherwise
     */
    public boolean equals(Object n){
        return (n instanceof PrimitivaNumber) &&
        this.number == ((PrimitivaNumber) n).number;
    }

    /**
     * Compares a (this) PrimitivaNumber with another.
     * 
     * @param other the PrimitivaNumber to compare to this.
     * @return int < 0 if this is lower than other,
     *         int > 0 if this is larger than other
     *          0      if this and other are equal
     */
    @Override
    public int compareTo(PrimitivaNumber n){
        return this.number - n.number;
    }

    /**
     * Returns the String that represents a (this) PrimitivaNumber
     * in text format
     * 
     * @return the String with the NumeroPrimitiva in text format.
     */
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
