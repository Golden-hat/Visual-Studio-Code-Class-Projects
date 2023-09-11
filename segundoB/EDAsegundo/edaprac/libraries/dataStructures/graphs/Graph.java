package libraries.dataStructures.graphs;

import libraries.dataStructures.models.*;
import libraries.dataStructures.linear.ArrayQueue;

import libraries.dataStructures.models.UFSet;
import libraries.dataStructures.hierarchical.ForestUFSet;
import libraries.dataStructures.models.PriorityQueue;
import libraries.dataStructures.hierarchical.BinaryHeapR0;

/** Abstract Graph class: basis for the Graph hierarchy, which
 *  defines a graph's behaviour.<br>
 *  It isn't an interface because it includes both the code for the operations
 *  of a graph that are independent both of its type as of their implementation.<br>
 *
 *  @version December 2018
 */

public abstract class Graph {

    protected boolean isDirected; // Indicates whether a graph is Directed or not
    protected int[] visited;      // Nodes visited in a traversal
    protected int visitOrder;     // Order in which nodes are visited in a traversal
    protected Queue<Integer> q;   // Queue for a BFS traversal

    /** Creates and empty graph, Directed if directed is true
     *  or Undirected otherwise.
     *
     * @param directed The type of graph, Directed or Undirected
     */
    public Graph(boolean directed) { isDirected = directed; }

    /** Checks whether a graph is directed or not.
     *
     * @return boolean true if the graph is Directed, false if it is Undirected
     */
    public boolean isDirected() { return isDirected; }

    /** Returns the number of vertices in a graph.
     *
     * @return int number of vertices
     */
    public abstract int numVertices();

    /** Returns the number of edges in a graph.
     *
     * @return int number of edges
     */
    public abstract int numEdges();

    /** Checks whether the edge (i, j) belongs to a graph.
     *
     * @param i    Source vertex
     * @param j    Target vertex
     * @return boolean true if (i, j) appears in the graph, false otherwise.
     */
    public abstract boolean containsEdge(int i, int j);

    /** Returns the weight of the edge (i, j) in a graph, 0 if that edge
     *  is not contained in the graph.
     *
     * @param i    Source vertex
     * @param j    Target vertex
     * @return double Weight of the edge (i, j), or 0 if it doesn't exist.
     */
    public abstract double edgeWeight(int i, int j);

    /** If it isn't in the graph, adds the edge (i, j) to an Unweighted graph.
     *
     * @param i    Source vertex
     * @param j    Target vertex
     */
    public abstract void addEdge(int i, int j);

    /** If it isn't in the graph, adds the edge (i, j) with weight w to a Weighted graph.
     *
     * @param i    Source vertex
     * @param j    Target vertex
     * @param w    Weight of the edge (i, j)
     */
    public abstract void addEdge(int i, int j, double w);

    /** Returns a ListPOI that contains vertex i's adjacent vertices.
     *
     * @param i Vertex from which adjacent vertices are looked up.
     * @return ListPOI with the vertices adjacent to i
     */
    public abstract ListPOI<Adjacent> adjacentTo(int i);

    /** Returns a String with each of the vertices of a graph
     *  and their adjacent vertices, in insertion order.
     *
     * @return  String representing a Graph
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int  i = 0; i < numVertices(); i++) {
            res.append("Vertex: ").append(i);
            ListPOI<Adjacent> l = adjacentTo(i);
            res.append(l.isEmpty() ? " without" : " with").append(" adjacents");
            for (l.begin(); !l.isEnd(); l.next()) {
                res.append(" ").append(l.get());
            }
            res.append("\n");
        }
        return res.toString();
    }

    /** Returns an array with each of the vertices of a graph and their
     *  adjacent vertices, in BFS order.
     *
     * @return  Vertex array visited in a BFS traversal
     */
    public int[] toArrayBFS() {
        int[] res = new int[numVertices()];
        visited = new int[numVertices()];
        visitOrder = 0;
        
        q = new ArrayQueue<>();
        for (int  i = 0; i < numVertices(); i++) {
            if (visited[i] == 0) {
                toArrayBFS(i, res);
            }
        }
        return res;
    }

    // BFS traversal from the source vertex, which stores its result in res
    protected void toArrayBFS(int origin, int[] res) {
        res[visitOrder++] = origin;
        visited[origin] = 1;
        q.enqueue(origin);
        
        while (!q.isEmpty()) {
            int u = q.dequeue();
            ListPOI<Adjacent> l = adjacentTo(u);
            for (l.begin(); !l.isEnd(); l.next()) {
                Adjacent a = l.get();
                if (visited[a.target] == 0) {
                    res[visitOrder++] = a.target;
                    visited[a.target] = 1;
                    q.enqueue(a.target);
                }
            }
        }
    }
    
    /** PRECONDITION: !this.isDirected()
     *  Returns a subset of edges that connect all vertices in an Undirected
     *  and Connected graph, or null if the graph is Unconnected.
     *
     * @return Edge[], array with the numV - 1 edges that connect the numV
     *         vertices of the graph, or null if the graph is Unconnected.
     */
    public Edge[] bfsSpanningTree() {
        Edge[] res = new Edge[numVertices() - 1];
        visited = new int[numVertices()];
        visitOrder = 0;
        
        q = new ArrayQueue<>();
        bfsSpanningTree(0, res);
        
        if(visitOrder != numVertices()-1){
            return null;
        }else{
            return res;
        }
    }

    protected void bfsSpanningTree(int origin, Edge[] res) {;
        visited[origin] = 1;
        q.enqueue(origin);
        
        while (!q.isEmpty()) {
            int u = q.dequeue().intValue();
            ListPOI<Adjacent> l = adjacentTo(u);
            for (l.begin(); !l.isEnd(); l.next()) {
                Adjacent a = l.get();
                if (visited[a.target] == 0) {
                    res[visitOrder++] = new Edge(u, a.getTarget(), a.getWeight());
                    visited[a.target] = 1;
                    q.enqueue(a.target);
                }
            }
        }
    }

    /** PRECONDITION: !this.isDirected()
     * Returns a subset of edges that, with minimal cost, connect all the
     * vertices of an Undirected and Connected graph, or null if the graph
     * is Unconnected.
     *
     * @return Edge[], array with the numV - 1 edges that connect the numV
     *         vertices with minimum cost, or null if the graph is Unconnected
     */
    public Edge[] kruskal() {    
        Edge[] aristas = new Edge[numVertices() -1]; int cardinal = 0;
        int[] array = this.toArrayBFS();
        PriorityQueue<Edge> aristasfactibles = new BinaryHeapR0<Edge>();
        ForestUFSet ufo = new ForestUFSet(numVertices());
        int aux;
        int xua;
        
        for(int i = 0;i<numVertices();i++){
            ListPOI<Adjacent> l = adjacentTo(i);        
            for(l.begin();!l.isEnd();l.next()){
                Adjacent ad = l.get();
                aristasfactibles.add(new Edge(i,ad.getTarget(),ad.getWeight()));
            }
        }
        
        while(cardinal < numVertices() - 1 && !aristasfactibles.isEmpty() ){
            Edge arista = aristasfactibles.removeMin();
            aux = ufo.find(arista.getSource());
            xua = ufo.find(arista.getTarget());
            if( aux != xua ){
                aristas[cardinal++]=arista;
                ufo.union(aux,xua);
            }
        }
        
        if(cardinal == numVertices() - 1) return aristas;
        return null;
    }
    
    public int highestDegreeVertex(){
        kruskal();
        int value = 0;
        int ret = 0;
        for(int i = 0; i < numVertices(); i++){
            ListPOI<Adjacent> listAdj =  adjacentTo(i);
            int degreeVertexI = listAdj.size();
            if(degreeVertexI >= value){
                value = degreeVertexI;
                ret = i;
            }
        }
        return ret;
    }
}