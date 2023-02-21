package segundoB.csd.EjerciciosTema1;

public class T extends Thread /**implements Runnable **/{
    protected int n;
    public T(int n) {this.n = n;}

    public void delay(int ms) {
        // suspends execution for ms milliseconds
        try {Thread.sleep(ms);} 
        catch (InterruptedException ie){ie.printStackTrace();}
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Thread "+n +" iteration "+i);
            delay((n+1)*1000);
        }
        System.out.println("End of thread "+n);
    }

    public static void main(String[] argv) throws InterruptedException{
        System.out.println("--- Begin of execution ---- ");
        T [] threads = new T[6];
        for (int i=0; i<6; i++) {
            T thread = new T(i);
            thread.start();
            threads[i] = thread;
            //new T(i).start(); /** new Thread(new T(i)).start(); **/
        }
        for(int i = 0; i < 6; i++){
            threads[i].join();
        }
        System.out.println("--- End of execution ---- ");
    }
}