// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    public int insNum = 0;
    public int kidNum = 0;
    public int KI = 0;
    public void init(int ki, int cap){this.KI = ki;}

    public synchronized void kidSwims() throws InterruptedException{
        while(insNum <= 0 || kidNum >= this.KI*insNum){
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
    }

    public synchronized void instructorRests() throws InterruptedException{
        while((kidNum > 0 && insNum == 1) || kidNum > this.KI*(insNum-1)){
            log.waitingToRest();
            wait();
        }
        insNum--;
        log.resting();
    }
}