import java.util.concurrent.locks.*;
import java.util.concurrent.*;
/**
 * Write a description of class Terrain1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terrain3 implements Terrain{
    Viewer v;
    ReentrantLock lock;
    Condition cond[][];
    
    public  Terrain3 (int t, int ants, int movs, String msg) {
        v = new Viewer(t,ants,movs,msg);
        lock = new ReentrantLock();
        cond = new Condition[t][t];
        for(int i = 0; i < cond.length; i++){
            for(int j = 0; j < cond.length; j++){
                cond[i][j] = lock.newCondition();
            }
        }
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
            int x = v.getPos(a).x;
            int y = v.getPos(a).y;
            v.bye(a);
            cond[x][y].signal();
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
            int prevX = v.getPos(a).x;
            int prevY = v.getPos(a).y;
            while (v.occupied(dest)) {
                int x = dest.x;
                int y = dest.y;
                if(cond[x][y].await(300, TimeUnit.MILLISECONDS)){
                    v.retry(a);
                }
                else{
                    v.chgDir(a);
                    dest = v.dest(a);
                    v.retry(a);
                }
            }
            v.go(a); 
            cond[prevX][prevY].signal();
        }
        finally{
            lock.unlock();
        }
    }
}