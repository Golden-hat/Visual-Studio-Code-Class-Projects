package segundoB.csd.EjerciciosTema3.ProductorConsumidor;

public class Consumidor implements Runnable{

    private Caja c = new Caja();
    private int id;

    public Consumidor(Caja c, int n){
        this.c = c;
        this.id = n;
    }

    public void run(){
        for(int i = 1; i < 10; i++){
            int n = c.quitar();
            System.out.println("Soy el hilo consumidor '"+id+"', y quito: " + n+".");
            try{
                Thread.sleep((int) Math.random() * 100);
            } catch(InterruptedException e){}
        }
    }
}
