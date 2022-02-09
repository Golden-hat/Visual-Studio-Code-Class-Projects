package primeroB;
public class Recurrencias{

    public static void main(String[] args) {
       printNum(10);
       System.out.println(evenOddDivision(70, 4));
       //THE ARITHMETIC OPERATION IS ONLY EXECUTED WHEN THE RECURSIVE METHOD IS OVER
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
    
    public static void printNum(int n){
        if(n == 1){
            System.out.println(n);
        }
        else{
            printNum(n-1);
            System.out.println(n + " ");
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
        if(b == 0){
            return 0;
        }
        else{
            return MultAddition(a, (b-1)) + a;
        }
    }

    public static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        }
        else{
            return n % 10 + sumOfDigits(n/10);
        }
    }

    public static int evenOddDivision(int a, int b){
        if(b == 0){
            return 0;
        }
        else if (b%2 == 0){
            return evenOddDivision(a*2, b/2);
        }
        else{
            return evenOddDivision(a*2, b/2) + a;
        }
    }
}