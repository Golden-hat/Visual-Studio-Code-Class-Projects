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
        /* TO BE COMPLETED */
    }

    /** Includes a new PrintJob j in a PrintServer.
     *  @param j   PrintJob to be added to the server.
     */
    public void add(PrintJob j) {
        /* TO BE COMPLETED */
    }

    /** Checks whether there is any PrintJob to be printed in a PrintServer. */
    public boolean hasJobs() {
        /* TO BE COMPLETED */
    }
    
    /** IFF hasJobs(): returns the PrintJob to be printed.
     *  @return PrintJob that will be printed next.
     */
    public PrintJob getJob() {
        /* TO BE COMPLETED */
    }

    /** IFF hasJobs(): removes from a PrintServer the PrintJob
     *  that is going to be printed and returns the time it will take
     *  to print, based on the printer's speed.
     *  @return time in seconds
     */
    public int printJob() {
        /* TO BE COMPLETED */
        return (int) (Math.round(60.0 * job.getNumPages() / PAGES_PER_MINUTE));
    }
}
