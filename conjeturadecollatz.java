public class conjeturadecollatz{
    public static void main(String[] args) {
        collatz(1273872612);
    }
    public static void collatz(long n){
        long currResult = n;
        int iteraciones = 1;
        do{
            if(currResult%2 != 0){
                currResult = 3*currResult+1;
                System.out.print(iteraciones+ ". ");
                System.out.println(currResult);
            }
            if(currResult%2 == 0){
                currResult = currResult/2;
                System.out.print(iteraciones+ ". ");
                System.out.println(currResult);
            }
            ++iteraciones;
        }while(currResult != 1);

    }
}