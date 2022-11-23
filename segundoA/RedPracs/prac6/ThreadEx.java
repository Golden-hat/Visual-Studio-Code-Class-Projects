package prac6;

public class ThreadEx extends Thread{

    String message;

    public ThreadEx (String text) {message = text;}

    public void run(){
        for(int i = 0; i < 10; i ++){
            System.out.println(message);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadEx("Hola!").start();
    }
}
