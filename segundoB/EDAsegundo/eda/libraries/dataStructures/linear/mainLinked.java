package libraries.dataStructures.linear;

public class mainLinked {
    public static void main(String[] args) {
        LinkedQueue<Integer> n = new LinkedQueue<Integer>();
        Integer[] arr = {12,3,4,5,5,3,2,3,4,23,42,34,1};
        for(int i = 0; i < arr.length; i++){
            n.enqueue(arr[i]);
        } 
        n.dequeue();
        System.out.println(n.toString());
    }
}
