package applications.printer;

import libraries.dataStructures.models.PriorityQueue;
import libraries.dataStructures.hierarchical.BinaryHeapR0;

/** Clase ServidorColaPrioridad: implementa un ServidorDeImpresion
 *  que usa un modelo de maxima prioridad (ColaPrioridad) para 
 *  gestionar los trabajos a la espera de ser impresos que almacena.
 *  
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */

public class PriorityQueueServer implements PrintServer {
    
    // A PriorityQueueServer HAS A PriorityQueue pQ of
    // PrintJobs waiting to be printed
    private PriorityQueue<PrintJob> pQ;
    
    /** Creates an empty Print Server. */
    public PriorityQueueServer() {
        pQ = new BinaryHeapR0<PrintJob>();
    }

    /** Includes a new PrintJob j in a PrintServer.
     *  @param j   PrintJob to be added to the server.
     */
    public void add(PrintJob j) {
        pQ.add(j);
    }

    /** Checks whether there is any PrintJob to be printed in a PrintServer. */
    public boolean hasJobs() {
        return !pQ.isEmpty();
    }
    
    /** IFF hasJobs(): returns the PrintJob to be printed.
     *  @return PrintJob that will be printed next.
     */
    public PrintJob getJob() {
        if(hasJobs()){
            return pQ.getMin();
        }
        return null;
    }

    /** IFF hasJobs(): removes from a PrintServer the PrintJob
     *  that is going to be printed and returns the time it will take
     *  to print, based on the printer's speed.
     *  @return time in seconds
     */
    public int printJob() {
        PrintJob job = pQ.removeMin();
        return (int) (Math.round(60.0 * job.getNumPages() / PAGES_PER_MINUTE));
    }
}
