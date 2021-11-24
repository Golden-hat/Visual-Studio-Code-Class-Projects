public class conjeturadecollatz{
    public static void main(String[] args) {
        collatz(871);
    }
    public static void collatz(long n){
        long currResult = n;
        int iteraciones = 0;
        System.out.println("0. "+n);
        do{
            if(currResult%2 != 0){
                ++iteraciones;
                currResult = 3*currResult+1;
                System.out.print(iteraciones+ ". ");
                System.out.println(currResult);
            }
            if(currResult%2 == 0){
                ++iteraciones;
                currResult = currResult/2;
                System.out.print(iteraciones+ ". ");
                System.out.println(currResult);
            }
        }while(currResult != 1);

    }
}