package primeroB.LinkedSequences.LinkedCharSequences.exercises;
import primeroB.LinkedSequences.LinkedCharSequences.LinkedCharSequence;

public class stringToLinkedSeq {

     
    public static void main(String[] args) {
        LinkedCharSequence k = new LinkedCharSequence();
        String a = "Examen";
        k.convertToLinkedSeq(a);
        System.out.println(k);
        k.append('t');
        k.append('j');
        System.out.println(k);
    }
}
