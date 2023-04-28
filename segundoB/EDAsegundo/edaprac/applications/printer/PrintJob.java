package applications.printer;

/** PrintJob class: represents a print job.
 *  ATTRIBUTES:
 *      HAS A title (String)
 *      HAS A number of pages (int)
 *      HAS AN instant in time (in seconds)
 *      in which it "enters" (is sent to) the print server (int)
 *
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */
 
public class PrintJob implements Comparable<PrintJob>{
    
    private String title;
    private int numPages;
    private int enteredServer;
    
    /** Creates a PrintJob with title t, number of pages n
     *  and time that it "entered" the server e.
     *  @param t    String
     *  @param n    int (pages)
     *  @param e    int (seconds)
     */
    public PrintJob(String t, int n, int e) {
        title = t;
        numPages = n;
        enteredServer = e;
    }
    
    /** Returns the title of a PrintJob */
    public String getTitle() { return title; }
    
    /** Returns the number of pages of a PrintJob. */
    public int getNumPages() { return numPages; }
    
    /** Returns the time instant (in seconds) in which a PrintJob
     *  "enters" the print server. */
    public int getEnteredServer() { return enteredServer; }

    /** Returns the integer value that results from comparing
     *  the number of pages of a PrintJob (this) with other's.
     *  Said value will be...
     *  ** NEGATIVE if a PrintJob (this) has FEWER pages than other,
     *     i.e. printing it has a HIGHER priority than other.
     *  ** POSITIVE if a PrintJob (this) has MORE pages than other,
     *     i.e. printing it has a LOWER priority than other.
     *  ** ZERO if both PrintJobs have the same number of pages.
     *  @param other The PrintJob to compare to.
     *  @return int result of comparing a PrintJob (this) with other
     */
    public int compareTo(PrintJob other) {
        return this.numPages - other.numPages;
    }
    
    /** Returns a String representation of a PrintJob in a specific format */
    public String toString() {
        return String.format("%s (%d pages) Enters the server at %d s.", title, numPages, enteredServer);
    }
}
