package segundoB.csd.EjerciciosTema3;
import java.util.concurrent.Semaphore;

public class MyMonitor {
    private int contqueue;
    private Semaphore specialqueue;
    private Semaphore mmutex;
    
    public MyMonitor(){
        contqueue=0;
        specialqueue= new Semaphore(0, true);
        mmutex = new Semaphore(1,true);
    }
    
    /* De manera similar, estos métodos tampoco necesitan
     * ser synchronized, ya que no tratan con variables
     * compartidas.
     */

    public void enter() throws InterruptedException{
        mmutex.acquire();
    }

    public void leave() {
        if (contqueue > 0) specialqueue.release();
        /* En esta implementación se da prioridad a 
         * la cola especial.
         */
        else mmutex.release();
    }

    public MyCondition newCond() {
        return new MyCondition();
    }

    public class MyCondition {
        private Semaphore csem;
        private int contcsem;
        
        /* Este constructor es privado, por lo
         * que no puede utilizarse fuera del contexto de uso de la clase
         * MyMonitor (es decir, no puede crearse instancias de la clase
         * MyCondition por sí solas!).
         * 
         * "Podemos utilizar directamente el constructor de MyCondition desde cualquier hilo para crear una
         * variable condición, y la funcionalidad de dicha variable condición será la adecuada en el monitor."
         * ES FALSA
         */

        private MyCondition() { 
            csem = new Semaphore(0,true);
            // El semáforo csem representa la cola asociada a una variable condición.
            // Justificación: se utiliza dentro de la clase MyCondition para conseguir que los hilos se suspendan en la
            // variable condición representada por dicha clase
            contcsem = 0;
        }

        /* Estos métodos NO NECESITAN LA KEYWORD 
         * synchronized, ya que solo son ejecutados dentro
         * de otros hilos, y solo 1 hilo a la vez puede acceder a la sección crítica,
         * como puede verse por el Semaphore mmutex
         */

        public void cwait() throws InterruptedException {
            contcsem++;
            if (contqueue > 0 ) specialqueue.release();
            else mmutex.release();
            /* Como el hilo ha pasado a esperar, el mutex
             * debe liberarse para que otros hilos puedan 
             * entrar.
             */
            csem.acquire();
            contcsem--;
        }

        public void cnotify() throws InterruptedException {
            /* Este método solo hace cosas si contcsem > 0, 
             * por lo que actúa de manera similar al notify
             * de un monitor de hoare.
             */
            if (contcsem > 0 ){
                contqueue++;
                csem.release();
                specialqueue.acquire();
                contqueue--;
            }
        }

        // Esta implementación asegura que, cuando un hilo A notifica a un hilo B que estaba esperando en
        // una variable condición, el hilo B encontrará el estado del monitor exactamente igual al estado que
        // tenía cuando el hilo A hizo la notificación.
        // Justificación: quien realiza la notificación reactiva al hilo suspendido en la condición (bloqueado en el
        // semáforo csem) y se suspende en la cola especial (bloqueándose en el semáforo specialqueue). Además, como
        // el semáforo asociado a la entrada al monitor (semáforo mmutex) sigue sin permisos, ningún otro hilo podrá
        // entrar al monitor (solamente el que ha sido reactivado). 
    }
}