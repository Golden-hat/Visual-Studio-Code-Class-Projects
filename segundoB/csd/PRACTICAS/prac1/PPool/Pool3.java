// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    public int insNum = 0;
    public int kidNum = 0;
    public int KI = 0;
    public int max = 0;
    public void init(int ki, int cap){this.KI = ki; this.max = cap;}
    public synchronized void kidSwims() throws InterruptedException{
        while((insNum <= 0 || kidNum >= this.KI*insNum) && (insNum + kidNum >= max - 1)){
            log.waitingToSwim();
            wait();
        }
        kidNum++;
        log.swimming();
        notifyAll();
    }
    public synchronized void kidRests() throws InterruptedException{
        kidNum--;
        log.resting();
        notifyAll();
    }
    public synchronized void instructorSwims() throws InterruptedException{
        while((insNum + kidNum) >= max - 1){
            log.waitingToSwim();
            wait();
        }
        insNum++;
        log.swimming();
        notifyAll();
    }
    public synchronized void instructorRests() throws InterruptedException{
        while((kidNum > 0 && insNum < 2) || kidNum >= this.KI*(insNum-1)){
            if (kidNum < 1) { // si es 0>=
                break;
            }
            log.waitingToRest();
            wait();
        }
        insNum--;
        log.resting();
        notifyAll();
    }
}