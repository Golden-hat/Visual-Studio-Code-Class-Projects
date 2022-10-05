package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class SplitQueues {
    public static void main(String[] args) {
        QueueIntLinked k = new QueueIntLinked();
        int a[] = {1, 2, 2, 4, 3, 1};
        k.ArrayAddToQueue(a);
        System.out.println(k.divideQueue());
        System.out.println(k.size());
        System.out.println(k);
    }


}
