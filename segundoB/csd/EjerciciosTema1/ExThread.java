package segundoB.csd.EjerciciosTema1;

public class ExThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
            for (int i=0; i<10; i++){
                Thread t = new Thread(){
                    public void run() {
                        System.out.println("executed by"+ Thread.currentThread().getName());
                    }
                };
            t.setName("Thread: "+i);
            t.start();
        }
    }
}