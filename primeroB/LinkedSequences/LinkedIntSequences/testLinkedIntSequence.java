package primeroB.LinkedSequences.LinkedIntSequences;

public class testLinkedIntSequence {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();

        int[] z = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        System.out.println(k.toString()+"\n");
        System.out.println(k.deleteFoundElementV2(89)+"\n");
        System.out.println(k.toString()+"\n");
        System.out.println(k.appendArrayNumbers(z)+"\n");
        k.addElement(15, 14);
        System.out.println(k.toString()+"\n");
        k.addElement(2142, 1);
        k.addElement(2142, 209);
        k.addElement(2142, 4);
        k.addElement(2142, 5);
        k.addElement(2142, 193832);
        System.out.println(k.toString()+"\n");
    }
}
