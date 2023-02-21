package segundoB.csd.EjerciciosTema1;
public class lambdaExpression {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<10; i++){
            Runnable thread = () -> System.out.println("executed by"+Thread.currentThread().getName());
            // se instancia una interfaz que solo tiene un metodo (metodo run), y por "patter matching" se le asocian las ordenes de la función anónima () -> ...
            // de tal manera, esta instancia guarda una implementación del método run, que se puede ejecutar por medio de un hilo
            new Thread(thread).start();
        } 
    } 
}