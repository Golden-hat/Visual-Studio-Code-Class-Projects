package primeroB.LinkedSequences.StackIntLinked.exercises;
import primeroB.LinkedSequences.StackIntLinked.*;

public class removeGreaterThan {

    public static StackIntLinked k = new StackIntLinked();

    public static void main(String[] args){
        
        k.push(1);
        k.push(2);
        k.push(3);
        k.push(4);
        k.push(5);
        k.push(6);
        k.push(7);
        k.push(8);
        k.push(9);
        k.push(10);
        k.toString();
        System.out.println("\n");
        removeGreaterThanX(k, 4).toString();
        System.out.println("\n");
        k.toString();

        StackIntLinked kak = new StackIntLinked(k);
        kak.toString();
    }

    public static StackIntLinked removeGreaterThanX(StackIntLinked k, int x){
        StackIntLinked p = new StackIntLinked();
        StackIntLinked pReturn = new StackIntLinked();

        //These lines invert the whole stack so that they are in order ready for sorting.
        while(!k.empty()){
            p.push(k.pop());
        }

        while(!p.empty()){
            int n = p.pop();
            if(n > x){
                pReturn.push(n);
            }
            else{
                k.push(n);
            }
        }
        return pReturn;
    }

}
