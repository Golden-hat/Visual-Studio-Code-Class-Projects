package segundoB.csd.EjerciciosTema3.ProductorConsumidor;

public class ProdCons {
    public static void main(String[] args) {
        Caja c = new Caja();

        Productor prod = new Productor(c, 1);
        Consumidor cons = new Consumidor(c, 2);

        new Thread(prod).start();  
        new Thread(cons).start();
    }
}
