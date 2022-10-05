package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.NodeInt4Queues;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class sumDigits {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        QueueIntLinked k = new QueueIntLinked();
        k.ArrayAddToQueue(a);
        System.out.println(fromQueueToInt(k));
    }

    public static int fromQueueToInt(QueueIntLinked q){
        NodeInt4Queues aux = q.first;
        int j = q.size - 1;

        int sum = 0;
        while(j >= 0){
            sum += (int) aux.getData()*Math.pow(10, j);
            aux = aux.next;
            j--;
        }
        return sum;
    }
}
