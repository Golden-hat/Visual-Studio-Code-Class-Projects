import java.util.concurrent.locks.*;
/**
 * Write a description of class Terrain1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terrain1 implements Terrain{
    Viewer v;
    ReentrantLock lock;
    Condition cond;
    
    public  Terrain1 (int t, int ants, int movs, String msg) {
        v = new Viewer(t,ants,movs,msg);
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    
    public void hi (int a) {
        try{
            lock.lock();
            v.hi(a);
        }
        finally{
            lock.unlock();
        }
    }
    public void bye (int a) {
        try{
            lock.lock();
            v.bye(a);
            cond.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    public void move (int a) throws InterruptedException {
        try{
            lock.lock();
            v.turn(a); 
            Pos dest = v.dest(a); 
            while (v.occupied(dest)) {
                cond.await();
                v.retry(a);
            }
            v.go(a);
            cond.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
}
