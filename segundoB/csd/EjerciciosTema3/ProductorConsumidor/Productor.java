package segundoB.csd.EjerciciosTema3.ProductorConsumidor;

public class Productor implements Runnable{

    private Caja c = new Caja();
    private int id;

    public Productor(Caja c, int n){
        this.c = c;
        this.id = n;
    }

    public void run(){
        for(int i = 1; i < 10; i++){
            c.poner(i);
            System.out.println("Soy el hilo productor '"+id+"', y pongo: " +i+".");
            try{
                Thread.sleep((int) Math.random() * 100);
            } catch(InterruptedException e){}
        }
    }
}
