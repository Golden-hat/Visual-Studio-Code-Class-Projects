package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.NodeInt4Queues;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class alternatingQueues {
    public static QueueIntLinked n = new QueueIntLinked();
    public static QueueIntLinked k = new QueueIntLinked();

    public static void main(String[] args) {
        int s[] = {3, 6, 20, 1, -3, 4, -5};
        int t[] = {10, 9, 8};
        n.ArrayAddToQueue(s);
        k.ArrayAddToQueue(t);
        System.out.println(n);
        System.out.println(k);
        System.out.println(fusion(n, k)); 
    }

    //Esta implementación NO UTILIZA EXCLUSIVAMENTE los métodos de la clase QueueIntLinked. Curso 2017-18.
    public static QueueIntLinked fusion(QueueIntLinked q1, QueueIntLinked q2){
        QueueIntLinked aux = new QueueIntLinked();
        int minimum = Math.min(q1.size(), q2.size());

        NodeInt4Queues firstq1 = q1.first;
        NodeInt4Queues firstq2 = q2.first;

        for(int i = 0; i < minimum; i++){
            aux.addToQueue(firstq1.data);
            aux.addToQueue(firstq2.data);
            firstq1 = firstq1.getNext();
            firstq2 = firstq2.getNext();
        }
        while(minimum < q1.size()){
            aux.addToQueue(firstq1.data);
            firstq1 = firstq1.getNext();
            minimum++;
        }
        while(minimum < q2.size()){
            aux.addToQueue(firstq2.data);
            firstq2 = firstq2.getNext();
            minimum++;
        }
        return aux;
    }
}
