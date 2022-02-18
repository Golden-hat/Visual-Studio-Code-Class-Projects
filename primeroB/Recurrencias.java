package primeroB;
public class Recurrencias{

    public static void main(String[] args) {

        String a[] = {"a","b","c","d","e","f","g","h"};
        printAlternate(a, a.length-1);
        System.out.println();
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
        int sign = 1;
        if (a < 0){
            sign *= -1;
            a = -a;
        }
        if (b < 0){
            sign *= -1;
            b = -b;
        }

        if(b == 0){
            return 0;
        }
        else if (b%2 == 0){
            return sign*evenOddDivision(a*2, b/2);
        }
        else{
            return sign*(evenOddDivision(a*2, b/2) + a);
        }
    }

    public static int TotalAmountDig(int n){
        if(n > 0){
            return TotalAmountDig(n/10) + 1;
        }
        else{
            return 0;
        }
    }

    public static void ReverseDigs(int n){
        if(n == 0){
            System.out.print("0");
        }
        if(n > 0){
            System.out.print(n%10);
            ReverseDigs(n/10);
        }
    }
    
    public static int ReverseRet(int n, int r){
        if(n == 0){
            return r;
        }
        else{
           return ReverseRet(n/10, n%10 + r*10);
        }

    }

    public static void DecimaltoBinary(int n){
        if(2 > n){
            System.out.print(n);
        }
        else{
            DecimaltoBinary(n/2);
            System.out.print(n%2);
        }
    }

    public static int DecimaltoBinaryRet(int n){
        if(2 > n){
            return n;
        }
        else{
            return 10*DecimaltoBinaryRet(n/2)+(n%2);
        }
    }

    public static boolean isPrefix(String s1, String s2, int i){
        if(i < 0){
            return true;
        }
        else{
            return s1.charAt(i) == s2.charAt(i) && isPrefix(s1, s2, i-1);
        }
    }
    public static boolean isPrefix(String s1, String s2){
        return s2.length() <= s1.length() && isPrefix(s1, s2, s2.length()-1);
    }

    public static boolean isSufix(String s1, String s2, int i, int j){
        if(j < 0){
            return true;
        }
        else{
            return s1.charAt(i) == s2.charAt(j) && isSufix(s1, s2, i-1, j-1);
        }
    }
    public static boolean isSufix(String s1, String s2){
        return s2.length() <= s1.length() && isSufix(s1, s2, s1.length()-1, s2.length()-1);
    }

    public static boolean contains(String s1, String s2, int i){
        if(isSufix(s1, s2, i, s2.length()-1)){
            return true;
        }
        else if(i < s2.length()-1){
            return false;
        }
        else{
            return contains(s1, s2, i-1);
        }
    }
    public static boolean contains(String s1, String s2){
        return s2.length() <= s1.length() && contains(s1, s2, s1.length()-1);
    }

    public static int pascalTriangle(int r, int i){
        if(i==0){
            return 1;
        }
        else if(i==r){
            return 1;
        }
        else{
            return pascalTriangle(r-1, i-1) + pascalTriangle(r-1, i);
        }
    }

    public static int BinarySearch(int v[], int left, int right, int x){
        if(left > right){
            return -1;
        }
        else{
            int k = (left+right)/2;
            if(v[k] == x){
                return k;
            }
            else if(v[k]<x){
                return BinarySearch(v, k+1, right, x);
            }
            else{
                return BinarySearch(v, left, k-1, x);
            }
        }
    }

    public static void printAlternate(String a[], int i){
        if(i < a.length/2){
            return;
        }
        else{
            System.out.print(a[a.length-1-i]+a[i]);
            printAlternate(a, i-1);
        }
    }
}