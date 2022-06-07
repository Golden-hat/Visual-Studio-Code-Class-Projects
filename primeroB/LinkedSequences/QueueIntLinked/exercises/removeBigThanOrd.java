package primeroB.LinkedSequences.QueueIntLinked.exercises;

import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class removeBigThanOrd {
    public static void main(String[] args) {
        QueueIntLinked k = new QueueIntLinked();
        int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        k.ArrayAddToQueue(a);
        System.out.println(k);
        k.removeBigThanInOrd(20);
        System.out.println(k);
        k.sneak(18);
        System.out.println(k);
    }
}
