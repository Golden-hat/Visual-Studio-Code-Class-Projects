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

    /* Attributes only */
    public void reverse(){
        int n = (qEnd-qBegin);
        
        for(int i = qBegin, j = 1; i < (int) (n/2); i++ ,j++){
            E aux = theArray[i];
            /* qEnd NO SIGUE la indexación en 0 */
            theArray[i] = theArray[qEnd-j];
            theArray[qEnd-j] = aux;
            System.out.println(theArray[i]);

            if (++i == theArray.length) i = 0;
            if (--j == -1) j = theArray.length - 1;
        }

        // SOLUCIÓN EJERCICIOS:
        // int i = qBegin, j = qEnd;

        // for (int cont = 0; cont < size/2; cont++) {
        //     E aux = theArray[i];
        //     theArray[i] = theArray[j];
        //     theArray[j] = aux;
        //     if (++i == theArray.length) i = 0;
        //     if (--j == -1) j = theArray.length - 1;
        // } 
    }

    /* Methods of the model */
    public void reverseMethods(){
        if(!isEmpty()){
            E aux = dequeue();
            reverseMethods();  
            enqueue(aux);
        }
        return;
    }



}