package primeroB;
public class Recurrencias{

    public static void main(String[] args) {
       printNum(10);
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
            //PauseTest();
            printNum(n-1);
            System.out.println(n);
            //PauseTest();
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

    public static int sumOfDigits(int n){
        if (n == 0){
            return 0;
        }
        else{
            return n % 10 + sumOfDigits(n/10);
        }
    }

    /*
    public static void PauseTest(){
   
        System.out.println("Press Enter Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
    */
    
}