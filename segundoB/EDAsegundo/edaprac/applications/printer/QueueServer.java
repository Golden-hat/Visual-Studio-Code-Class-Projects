package applications.printer;

import libraries.dataStructures.linear.ArrayQueue;
import libraries.dataStructures.models.Queue;

/** Clase ServidorCola: implementa un ServidorDeImpresion
 *  que usa un modelo FIFO (Cola) para gestionar los trabajos
 *  a la espera de ser impresos que almacena.
 *  
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */

public class QueueServer implements PrintServer {
    
    // A QueueServer HAS A Queue q of PrintJobs to be printed
    private Queue<PrintJob> q;
    
    /** Creates an empty Print Server. */
    public QueueServer() { q = new ArrayQueue<>(); }

    /** Includes a new PrintJob j in a PrintServer.
     *  @param j   PrintJob to be added to the server.
     */
    public void add(PrintJob j) { q.enqueue(j); }

    /** Checks whether there is any PrintJob to be printed in a PrintServer. */
    public boolean hasJobs() { return !q.isEmpty(); }

    /** IFF hasJobs(): returns the PrintJob to be printed.
     *  @return PrintJob that will be printed next.
     */
    public PrintJob getJob() { return q.first(); }

    /** IFF hasJobs(): removes from a PrintServer the PrintJob
     *  that is going to be printed and returns the time it will take
     *  to print, based on the printer's speed.
     *  @return time in seconds
     */
    public int printJob() {
        PrintJob job = q.dequeue();
        return (int) (Math.round(60.0 * job.getNumPages() / PAGES_PER_MINUTE));
    }
}
