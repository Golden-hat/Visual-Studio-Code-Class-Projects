package segundoB.csd.EjerciciosTema3.ProductorConsumidor;

public class Caja {
    private int contenido = 0;
    private boolean llena = false;

    public synchronized void poner(int n){
        while(llena){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        //while(!llena){Thread.yield();} ESTA ESTÁ MAL.
        this.contenido = n;
        llena = true;
        notifyAll();
    }

    // The progress condition is NOT met, as the threads get
    // blocked between them.
    // • Trace to be analyzed with empty box:
    // • enters consumer, takes the mutual exc. of its get
    // method (closes the implicit lock) and as the box is
    // empty it yields the processor (without releasing
    // the implicit lock)
    // • the producer will not be able to enter its “put”
    // method and write into the buffer. Both threads are
    // blocked.

    public synchronized int quitar(){
        while(!llena){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        //while(!llena){Thread.yield();} ESTA ESTÁ MAL.
        int valor = contenido;
        contenido = 0;
        llena = false;
        notifyAll();
        return valor;
    }
}
