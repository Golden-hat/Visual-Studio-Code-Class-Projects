package primeroA;

public class forExample{

    public static int product (int a, int b) {
    int result = 0;

        if (a != 0){
            for (int i = 0; i < a; i++){
                result += b;
            } 
        }else{
            result = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(product(0, 7));
    }
}