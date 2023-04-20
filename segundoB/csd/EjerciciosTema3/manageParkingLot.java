package segundoB.csd.EjerciciosTema3;
import java.util.concurrent.locks.Condition;

public class manageParkingLot{ //Monitor
    int n = 100; int nCars = 0; // Car limit set to 100
    int nWaitNorth = 0; int nWaitSouth = 0;
    boolean turnS = true; boolean turnN = true;
    Condition freeSpace;

    public void enterSouth() throws InterruptedException{
        nWaitSouth++;
        while(nCars == n || !turnS) { freeSpace.wait(); } // entran todos a una hasta que se llena por un lado. Para entonces, el turno se cede a la otra entrada.
        freeSpace.notify();
        nWaitSouth--;
        nCars ++;
        if (nCars == n) {turnS = false; turnN = true;}
    }

    public void enterNorth() throws InterruptedException{
        nWaitNorth++;
        while(nCars == n || !turnN) { freeSpace.wait(); }
            freeSpace.notify();
            nWaitNorth--;
            nCars ++;
        if (nCars == n) {turnS = true; turnN = false;}
    }

    public void exit(){ // full and people in both queues, the turnN turnS dont reset, and so the cars alternate the entrance.
        if (nCars < n ||
        (nCars == n && (nWaitNorth == 0 || nWaitSouth == 0 ))) {
            turnN = true;
            turnS = true;
        }
        nCars --;
        freeSpace.notify();
    }
}