package segundoB.csd.EjerciciosTema3;

public class ManagerOfPearls {
    final static private int NMaxWhites = 50;
    final static private int NMaxBlues = 50;

    private int NWhites = 0;
    private int NBlues = 0;

    private boolean OrderInProgress = false;

    public synchronized void AddWhite() {
        NWhites = NWhites++; 
        notifyAll();

        while (NWhites == NMaxWhites){ //NMaxWhites cannot be surpassed
        try {wait();} catch (InterruptedException e){
        Thread.currentThread().interrupt();}; }
    }

    public synchronized void AddBlue() {
        NBlues = NBlues++;
        notifyAll();
        while (NBlues == NMaxBlues){ //NMaxBlues cannot be surpassed
        try {wait();} catch (InterruptedException e){
        Thread.currentThread().interrupt();}; }
    }

    public synchronized void RequestOrder(int RequestWhites, int RequestBlues) {
        /* 
         * OrderInProgress attribute does not ensure mutual
         * exclusion, the synchronized method does. What OrderInProgress
         * Does is ensuring conditional synchronization.
         * 
         * The OrderInProgress attribute is used to ensure that when an order P1 is waiting
         * for the requested pearls to be completed, new orders will not be served until P1 is
         * completed.
         */ 
        while (OrderInProgress){
            try {wait();} catch (InterruptedException e){
            Thread.currentThread().interrupt();};
        };

        OrderInProgress = true;

        while (RequestWhites > NWhites || RequestBlues > NBlues){
            try {wait();} catch (InterruptedException e){
            Thread.currentThread().interrupt();};
        };
        NWhites = NWhites - RequestWhites;
        NBlues = NBlues - RequestBlues;
        OrderInProgress = false;
        notifyAll();
    }
}