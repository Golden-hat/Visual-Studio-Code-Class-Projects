package primeroB.LinkedSequences.LinkedIntSequences.exercises;
import primeroB.LinkedSequences.LinkedIntSequences.LinkedIntSequence;

public class adelantar {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();
        int a[] = {1,2,3,4,5,6,7,8,9};
        k.appendArrayNumbers(a);
        k.adelantar(1);
        System.out.println(k);
    }
}
