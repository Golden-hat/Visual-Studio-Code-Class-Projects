// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    public int insNum = 0;
    public int kidNum = 0;
    public void init(int ki, int cap){insNum = 0; kidNum = 0;}
    
    public synchronized void kidSwims() throws InterruptedException{
        while(insNum <= 0){
            log.waitingToSwim();
            wait();
        }
        kidNum++;
        log.swimming();
    }

    public synchronized void kidRests() throws InterruptedException{
        kidNum--;
        log.resting();
        notifyAll();
    }

    public synchronized void instructorSwims() throws InterruptedException{
        insNum++;
        log.swimming();
        notifyAll();
    }

    public synchronized void instructorRests() throws InterruptedException{
        while(kidNum > 0 && insNum == 1){
            log.waitingToRest();
            wait();
        }
        insNum--;
        log.resting();
        notifyAll();
    }
}
