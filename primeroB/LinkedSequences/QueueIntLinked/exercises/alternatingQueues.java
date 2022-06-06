package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class alternatingQueues {
    public static QueueIntLinked n = new QueueIntLinked();
    public static QueueIntLinked k = new QueueIntLinked();

    public static void main(String[] args) {
        int s[] = {3, 6, 20, 1, -3, 4, -5};
        int t[] = {10, 9, 8};
        n.ArrayAddToQueue(s);
        k.ArrayAddToQueue(t);
        n.addToQueue(5);
        k.addToQueue(6);
        System.out.println(n);
        System.out.println(k);    
    }
}
