package libraries.dataStructures.graphs;

/**
 * VertexCost class
 * 
 * Auxiliary class, used in Dijkstra's algorithm
 * Inputs for the priority queue: pairs (code vertex, cost)
 */

class VertexCost implements Comparable<VertexCost> {
    protected int code; // Vertex code
    protected double cost; // Minimum cost to reach that vertex
  
    // Constructor
    public VertexCost(int code, double cost) { 
        code = code; 
        cost = cost; 
    }
  
    // Sets the priority: one vertex is of higher priority than another.
    // if the cost to reach it is lower
    public int compareTo(VertexCost v) {
        if (cost < v.cost) { return -1; }
        if (cost > v.cost) { return 1; }
        return 0;
    }
}