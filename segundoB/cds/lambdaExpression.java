package segundoB.cds;
public class lambdaExpression {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<10; i++){
            Runnable thread = () -> System.out.println("executed by"+Thread.currentThread().getName());
            new Thread(thread).start();
        } 
    } 
}