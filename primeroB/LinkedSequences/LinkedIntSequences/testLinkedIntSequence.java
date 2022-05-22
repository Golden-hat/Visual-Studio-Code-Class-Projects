package primeroB.LinkedSequences.LinkedIntSequences;

public class testLinkedIntSequence {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();

        int[] z = {1,4,5,6,3,6,2,3,6,2};

        k.append(89);
        k.append(209);
        k.append(2543209);
        k.append(6325209);
        k.append(125209);
        k.append(20159);
        k.append(2234509);
        System.out.println(k.toString()+"\n");
        System.out.println(k.deleteFoundElementV2(209)+"\n");
        System.out.println(k.toString()+"\n");
        System.out.println(k.appendArrayNumbers(z)+"\n");
        System.out.println(k.toString()+"\n");
    }
}
