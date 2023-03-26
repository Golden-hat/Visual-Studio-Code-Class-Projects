package libraries.dataStructures.models;

public interface QueuePlus<E> extends Queue<E> {
    /** obtains a Queue's size
     */
    int size();
    void reverse();
}