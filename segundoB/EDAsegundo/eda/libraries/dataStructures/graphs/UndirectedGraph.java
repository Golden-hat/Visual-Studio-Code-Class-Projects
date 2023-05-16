package libraries.dataStructures.graphs;

/** 
 * UnirectedGraph class
 *  
 * implementation of an Undirected graph (Weighted or not) 
 * using Adjacency Lists
 *  
 * an Undirected graph IS A Directed Graph such that 
 * if the Edge (i, j) is present in the Adjacency List of i 
 * then so is the Edge (j, i) in the Adjacency List of j
 */

public class UndirectedGraph extends DirectedGraph {
    
    /** Construct an empty Undirected graph with numV. 
     * @param numV Number of vertices of the empty graph.
     */
    public UndirectedGraph(int numV) { 
        super(numV); 
        isDirected = false;
    }
    
    /** If not present, add edge (i, j) into a graph. 
     * Undirected and Unweighted; 
     * therefore, it also adds edge (j, i).
     * @param i Source vertex
     * @param j Target vertex
     */ 
    public void addEdge(int i, int j) {
        addEdge(i, j, 1);
    }
    
    /** If not present, add edge (i, j) of weight p into a graph. 
     * Undirected and Weighted; 
     * therefore, also adds edge (j, i) of weight p.
     * @param i Source vertex
     * @param j Target vertex
     * @param p Weight of (i, j)
     */ 
    public void addEdge(int i, int j, int p) {
        if (!existsEdge(i, j)) { 
            theArray[i].add(new Adjacent(j, p)); 
            theArray[j].add(new Adjacent(i, p));
            numV++; 
        }
    }
    
    public int inDegree(int i) {
        return outDegree(i);
    }
}