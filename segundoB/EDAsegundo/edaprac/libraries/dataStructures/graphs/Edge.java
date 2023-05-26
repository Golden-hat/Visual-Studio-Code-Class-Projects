package libraries.dataStructures.graphs;

/** Edge Class: represents an edge in a graph.<br>
 *
 *  @version november 2021
 */

public class Edge implements Comparable<Edge>{

    // AN Edge HAS A source vertex AND A target vertex:
    private int source;
    private int target;
    // AN Edge HAS A weight:
    private int weight;

    /** Creates an edge (a, b) with weight w.
     *
     * @param a  Source vertex
     * @param b  Target vertex
     * @param w  Weight
     */
    public Edge(int a, int b, double w) {
        this.source = a;
        this.target = b;
        this.weight = weight;
    }

    /** Returns the source vertex of an edge.
     *
     * @return int source vertex
     */
    public int getSource() {
        return source;
    }

    /** Returns the target vertex of an edge.
     *
     * @return int target vertex
     */
    public int getTarget() {
        return target;
    }

    /** Reterns an edge's weight
     *
     * @return double Weight of the edge
     */
    public double getWeight() {
        return weight;
    }

    /** Returns a String that represents an edge
     *  in the format (source, target, weight)
     *
     * @return  String that represents the edge
     */
    public String toString() {
        return "("+source+", "+", "+target+", "+", "+weight+").";
    }
    
    @Override
    public int compareTo(Edge o){
        double res = this.weight - o.weight;
        
        if(res > 0){return 1;}
        else if(res < 0){return -1;}
        return 0;
    }
}
