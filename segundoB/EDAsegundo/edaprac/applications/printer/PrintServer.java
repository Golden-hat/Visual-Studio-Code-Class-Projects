package applications.printer;

/** PrintServer interface: specifies the speed of a printer associated
 *  to a Print Server and the methods it has to implement **independently**
 *  of the underlying queue (Queue or Priority Queue) that handles
 *  the print jobs that are waiting to be printed.
 *
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */

public interface PrintServer {

    // Speed of the printer associated to a server,
    // or number of pages per minute that it can print.
    public static final int PAGES_PER_MINUTE = 30;
    
    /** Includes a new PrintJob j in a PrintServer.
     *  @param j   PrintJob to be added to the server.
     */
    void add(PrintJob j);
    
    /** Checks whether there is any PrintJob to be printed in a PrintServer. */
    boolean hasJobs();
    
    /** IFF hasJobs(): returns the PrintJob to be printed.
     *  @return PrintJob that will be printed next.
     */
    PrintJob getJob();
    
   /** IFF hasJobs(): removes from a PrintServer the PrintJob
    *  that is going to be printed and returns the time it will take
    *  to print, based on the printer's speed.
    *  @return time in seconds
    */
    int printJob();
}
