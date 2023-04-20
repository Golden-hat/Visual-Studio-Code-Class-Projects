package libraries.dataStructures.linear;

public class mainLinked {
    public static void main(String[] args) {
        LinkedQueue<Integer> n = new LinkedQueue<Integer>();
        ArrayQueuePlus<Integer> x = new ArrayQueuePlus<Integer>();
        LinkedStackPlus<Integer> f = new LinkedStackPlus<Integer>();
        Integer[] arr = {1};
        for(int i = 0; i < arr.length; i++){
            n.enqueue(arr[i]);
            x.enqueue(arr[i]);
            f.push(arr[i]);
        } 
        n.dequeue();
        System.out.println(n.toString());
        x.reverse();
        System.out.println(x.toString());
        System.out.println(f.baseMetodos());
        

    }
}
