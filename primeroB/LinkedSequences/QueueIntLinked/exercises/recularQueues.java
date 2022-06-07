package primeroB.LinkedSequences.QueueIntLinked.exercises;
import primeroB.LinkedSequences.QueueIntLinked.QueueIntLinked;

public class recularQueues {
    public static QueueIntLinked k = new QueueIntLinked();
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        k.ArrayAddToQueue(a);
        System.out.println(k);
        recular(k, 8);
        System.out.println(k);
    }

    public static void recular(QueueIntLinked q, int x){
        QueueIntLinked aux = new QueueIntLinked();
        int i = 0;
        boolean found = false;
        int size = q.size();

        while(i < size && !found){
            if(q.element() != x){
                aux.addToQueue(q.removeFromQueue());
            }
            else{
                found = true;
                q.addToQueue(q.removeFromQueue());
            }
            i++;
        }

        i = 0;
        while(i < q.size){
            aux.addToQueue(q.removeFromQueue());
        }

        i = 0;
        while(i < aux.size){
            q.addToQueue(aux.removeFromQueue());
        }
    }
}
