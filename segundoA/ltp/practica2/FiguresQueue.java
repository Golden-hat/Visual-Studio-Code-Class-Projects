package ltp.practica2;
import ltp.practica1.Figure;
import ltp.practica2.librerias.implementaciones.QueueAL;

/**
 * class FiguresQueue.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresQueue<T extends Figure> extends QueueAL<T> { 
    public static void main(String[] args){
        QueueAL<Figure> q = new QueueAL<Figure>();
        Figure s = new Square(0,0,3);
        q.enqueue(new Figure(0, 0, 5, 6));
    }
}