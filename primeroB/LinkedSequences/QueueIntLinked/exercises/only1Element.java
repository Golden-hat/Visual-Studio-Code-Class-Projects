package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class only1Element {

    public static void main(String[] args) {
        QueueIntLinked k = new QueueIntLinked();
        int[] a = {1,2,3,3,3,3,3,3,7,7,7,7,7,4,4,4,4,2,2,2,2,5,5,5,6,7,8,8,9,10,10,10,11,11,11,12,13,13,13,14,14,15,15};
        k.ArrayAddToQueue(a);
        System.out.println(k);
        k.OnlyOneElement();
        System.out.println(k);
    }
}
