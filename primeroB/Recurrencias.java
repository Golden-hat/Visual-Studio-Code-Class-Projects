package primeroB;
public class Recurrencias{

    public static void main(String[] args) {
       System.out.println(DivSubstraction(50, 5)); 
    }

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static int factorial(int n){
        if(n == 0){
            return 0;
        }
        else if (n == 1){    
            return 1;
        }
        else{
            return n * factorial(n-1);
        } 
    }
    
    public static int printNum(int n){
        if(n == 0){
            return 0;
        }
        else{
            System.out.println(n);
            return printNum(n-1);
        }
    }

    public static int DivSubstraction(int a, int b){
        if(a < b){
            return 0;
        }
        else{
            return DivSubstraction(a-b, b) + 1;
        }
    }

    public static int MultAddition(int a, int b){
        if (b == 0){
            return 0;
        }
        else{
            return MultAddition(a, (b-1)) + a;
        }
    }
}