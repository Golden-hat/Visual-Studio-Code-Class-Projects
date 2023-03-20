package segundoB.csd.EjerciciosTema1;
//Question 1.
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
            /* If thread.run() had been used instead, the main
             * thread would have executed each one sequentially
             */
            threads[i] = thread;
            //new T(i).start(); /** new Thread(new T(i)).start(); **/
        }
        /* We can ensure the "End of execution" message printing
         * by creating the threads in an array and then making the main
         * thread to wait until they finish their execution. We need
         * to store our created threads in an array in order to "keep track"
         * any thread that we must also close. 
         */
        for(int i = 0; i < 6; i++){ //6 Threads have been created.
            threads[i].join();
        }
        System.out.println("--- End of execution ---- ");
    }
}