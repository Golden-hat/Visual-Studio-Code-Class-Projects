package primeroB.LinkedSequences.LinkedIntSequences;

public class testLinkedIntSequence {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();
        k.append(209);
        k.append(209123);
        k.append(20912);
        k.append(2029);
        k.append(202393);
        k.append(25409);
        k.append(205439);
        System.out.println(k.toString()+"\n");
        System.out.println(k.RemoveElem(209)+"\n");
        System.out.println(k.toString()+"\n");
    }
}
