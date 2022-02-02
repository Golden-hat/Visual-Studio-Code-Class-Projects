package primeroA;

import java.util.Scanner;
public class maximoComunDivisor {
    public static void main(String[] args) {

        int value = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please provide your first number: "); int a = sc.nextInt();
        System.out.print("Please provide your second number: "); int b = sc.nextInt();
       
        while (a!=0 && b!=0 && a != b){
            if (a > b){
                a = a%b;
            }else{
                b = b%a;
            }
        }
        if(a == 0 && b == 0){
            value = 1;
        }else if(a==0){
            value = b;
        }else{
            value = a;
        }

        System.out.println("\nGreatest common divisor is "+value);
        sc.close();
    }
}