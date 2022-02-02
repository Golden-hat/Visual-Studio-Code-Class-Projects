package primeroA;
public class BasicArrayNonInput{
    public static void main(String Args[]){
        
        int[] paquito = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            int sum = 0;

        for ( int x= 0; x < paquito.length; x++){
            sum = sum + paquito[x];
         }
    
        System.out.println("La suma de todos los números de tu array es: " + sum);
    }
}