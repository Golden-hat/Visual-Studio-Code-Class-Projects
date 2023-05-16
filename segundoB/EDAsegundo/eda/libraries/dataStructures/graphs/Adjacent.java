package libraries.dataStructures.graphs;

/** 
 * Adjacent Class
 *  
 * Represents a vertex adjacent to another of a graph and the weight 
 * of the edge joining them; 
 * therefore, it can be considered as an implicit representation of the edge
 * that joins two vertices of a graph.
 */

public class Adjacent { 
    protected int target;
    protected double weight;
    
    /** 
     * Creates the vertex v adjacent to another vertex of a graph.  
     * and the weight of the edge joining them.
     * @param v Vertex adjacent to another one.
     * @param w Weight of the edge joining v and the other to which it is adjacent. 
     */
    public Adjacent(int v, double w) { 
        target = v;  
        weight = w; 
    }

    /** 
     * Returns the vertex adjacent to another vertex of a graph, 
     * or the target vertex of the edge joining them. 
     * @return int Vertex adjacent to other 
     */
    public int getTarget() { return target; }

    /** 
     * @returns the weight of the edge joining 
     * to a vertex of a graph to one adjacent to it. 
     * @return double Weight of the edge that joins 
     * an adjacent to a vertex of a graph, 
     * 1 if the graph is Unweighted.
     */
    public double getWeight() { return weight; }
     
    /**
     * Returns a String that represents an adjacent 
     * to a vertex of a graph and the weight of the edge joining them.
     * @return String 
     */     
    public String toString() { return target + "(" + weight + ") "; }
}