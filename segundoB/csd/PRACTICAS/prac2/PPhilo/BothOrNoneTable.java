// CSD Mar 2013 Juansa Sendra

public class BothOrNoneTable extends RegularTable { //both or none
    public BothOrNoneTable(StateManager state) {super(state);}
    
    @Override
    public synchronized void takeR(int id) throws InterruptedException {
        illegal("Fallo");
    }
    @Override
    public synchronized void takeL(int id) throws InterruptedException {    
        illegal("Fallo");
    }
    public synchronized void end(int id)   {state.end(id);}
    @Override
    public synchronized void takeLR(int id) throws InterruptedException{
        while (!(state.rightFree(id) && state.leftFree(id))) {state.wtakeLR(id); wait();}
        state.takeR(id);
        state.takeL(id);
    }
}
