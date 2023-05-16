package libraries.dataStructures.graphs;

import libraries.dataStructures.models.*;

/** abstract class Graph
 *
 * The basis of the Graph hierarchy, which defines the behavior of a graph.
 * It is not an interface because it includes the code for those operations of a graph that are independent
 * of both type and implementation.
 */

public abstract class Graph { 
    // "auxiliary" attributes
    protected boolean isDirected; // Indicates whether the graph is directed or not
    protected int[] visited; // Nodes visited for the traversals
    protected int orderVisited; // Order in which nodes are visited in the traversals
    protected Queue<Integer> q; // Queue for the BFS traversal
    
    /** Creates an empty graph, Directed if isDirected is true
     * or Undirected otherwise.
     * 
     * @param isDirected Indicates the type of the graph, Directed or Not.
     */
    public Graph(boolean isDirected) { this.isDirected = isDirected; }
    
    /** Checks whether or not a graph is Directed.
     *
     * @return boolean true if the graph is Directed and false if it is Not Directed.
     */
    public boolean isDirected() { return isDirected; }
    
    /** Returns the number of vertices in a graph.
     * @return int number of vertices of a graph.
     */
    public abstract int numVertices();
    
    /** Returns the number of edges of a graph.
     * @return int number of edges of a graph.
     */
    public abstract int numEdges();
    
    /** Checks if edge (i,j) is in a graph.
     * @param i Source vertex
     * @param j Target vertex
     * @return boolean true if (i,j) is and false otherwise.
     */
    public abstract boolean existsEdge(int i, int j);
    
    /** Returns the weight of edge (i,j) of a graph, 
     * 0 if the edge is not in the graph.
     * @param i Source vertex
     * @param j Destination vertex
     * @return double Weight of edge (i,j), 0 if it does not exist.
     */
    public abstract double edgeWeight(int i, int j);
    
    /** If not present, insert edge (i, j) into an unweighted graph.
     * @param i Source vertex
     * @param j Destination vertex
     */
    public abstract void addEdge(int i, int j);
    
    /** If not present, insert edge (i, j) of weight p into a Weighted graph.
     * @param i Source vertex
     * @param j Destination vertex
     * @param p Weight of edge (i,j)
     */
    public abstract void addEdge(int i, int j, double p);

    /** Returns a List with Point of Interest containing those adjacents to vertex i of a graph.
     * @param i Vertex from which the adjacents are obtained.
     * @return ListPOI containing the vertices adjacent to i
     */
    public abstract ListPOI<Adjacent> adjacentsTo(int i);
       
    /** Returns a String 
     * with each of the vertices of a graph and their adjacents, 
     * in order of insertion 
     * @return String representing a graph
     */        
    public String toString() {
        String res = "";  
        for (int i = 0 ; i < numVertices(); i++) {
            res += "Vertex: " + i;
            ListPOI<Adjacent> l = adjacentsTo(i);
            if (l.isEmpty()) { res += " without Adjacents "; }
            else { res += " with Adjacents "; } 
            for (l.begin(); !l.isEnd(); l.next()) {
                res += l.get() + " ";  
            }
            res += " ";  
        }
        return res;      
    }  
}