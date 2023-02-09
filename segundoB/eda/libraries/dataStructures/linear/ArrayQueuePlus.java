package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;

// An ArrayQueuePlus IS AN ArrayQueue that implements QueuePlus

public class ArrayQueuePlus<E> extends ArrayQueue<E> implements QueuePlus<E> {
    /** returns a Queue's size **/
    public final int size() {
        // using only methods inherited from ArrayQueue
        /* int res = 0;
           while (!this.isEmpty()) {
               E first = this.dequeue();
               res++; 
           }
           return res;
        */

        // using only attributes inherited from ArrayQueue,
        // the most efficient
        return super.size;
    }
}