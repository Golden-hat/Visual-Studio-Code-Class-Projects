package primeroB.LinkedSequences.LinkedIntSequences;

public class testLinkedIntSequence {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();

        int[] z = {1,4,5,6,3,6,2123,3,6,2};

        k.addElement(2142, 1);
        System.out.println(k.toString()+"\n");
        System.out.println(k.deleteFoundElementV2(89)+"\n");
        System.out.println(k.toString()+"\n");
        System.out.println(k.appendArrayNumbers(z)+"\n");
        System.out.println(k.toString()+"\n");
        k.addElement(2142, 1);
        k.addElement(2142, 209);
        k.addElement(2142, 4);
        k.addElement(2142, 5);
        k.addElement(2142, 193832);
        System.out.println(k.toString()+"\n");
    }
}
