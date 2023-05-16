package libraries.dataStructures.graphs;

import libraries.dataStructures.models.ListPOI; 
import libraries.dataStructures.linear.LinkedListPOI;
import libraries.dataStructures.models.Queue;
import libraries.dataStructures.linear.ArrayQueue;
import libraries.dataStructures.models.PriorityQueue;
import libraries.dataStructures.hierarchical.BinaryHeap;

/** 
 * DirectedGraph class
 *  
 * implementation of a Directed Graph (Weighted or not) 
 * using Adjacency Lists
 */

public class DirectedGraph extends Graph {     
    protected int numV; 
    protected int numE;
    protected ListPOI<Adjacent>[] theArray;
    
    /** Create an empty Directed graph with numVertices. 
     * @param numVertices Number of vertices of the empty graph.
     */
    @SuppressWarnings("unchecked")
    public DirectedGraph(int numVertices) {
        super(true);
        numV = numVertices; 
        numE = 0;
        theArray = new ListPOI[numVertices]; 
        for (int i = 0; i < numV; i++) 
            theArray[i] = new LinkedListPOI<Adjacent>();
    }
    
    /**
     * Returns the number of vertices in a graph. 
     * @return int Number of vertices of a graph.
     */
    public int numVertices() { return numV; }
     
    /**
     * Returns the number of edges of a graph.
     * @return int Number of edges of a graph.
     */
    public int numEdges() { return numE; }
    
    /** Returns a List With POI containing. 
     * the adjacent to vertex i of a graph.
     * @param i Vertex from which the adjacents are obtained.
     * @return ListPOI containing the vertices adjacent to i
     */
    public ListPOI<Adjacent> adjacentsTo(int i) { 
        return theArray[i]; 
    }
    
    /** Check if edge (i,j) is in a graph.
     * @param i Source vertex
     * @param j Target vertex
     * @return boolean true if (i,j) is and false otherwise.
     */
    public boolean existsEdge(int i, int j) {
        ListPOI<Adjacent> l = theArray[i]; 
        for (l.begin(); !l.isEnd(); l.next()) {
            if (l.get().getTarget() == j) { return true; }
        } 
        return false;   
    }
    
    /** Returns the weight of edge (i,j) of a graph, 
     * 0 if that edge is not in the graph.
     * @param i Source vertex
     * @param j Target vertex
     * @return double Weight of edge (i,j), 0 if it does not exist.
     */
    public double edgeWeight(int i, int j) {
        ListPOI<Adjacent> l = theArray[i];
        for (l.begin(); !l.isEnd(); l.next()) {
            if (l.get().getTarget() == j) {
                return l.get().getWeight();
            }
        }
        return 0.0;
    }
    
    /** If not present, add edge (i, j) in an unweighted graph
     * (at the beginning of the List of Adjacent to i).
     * @param i Source vertex
     * @param j Target vertex
     */    
    public void addEdge(int i, int j) {
        addEdge(i, j, 1);
    }

    /** If not present, add edge (i, j) of weight p into a Weighted graph. 
     * (at the beginning of the List of adjacent to i).
     * @param i Source vertex
     * @param j Target vertex
     * @param p Weight of (i, j)
     */ 
    public void addEdge(int i, int j, double p) {
        if (!existsEdge(i, j)) { 
            theArray[i].add(new Adjacent(j, p)); 
            numE++; 
        }
    }

    public int outDegree(int i) { 
        return theArray[i].size(); 
    }

    public int outDegree() { 
        int degreeMax = outDegree(0);
        for (int i = 1; i < numV; i++) { 
            int degree = outDegree(i); 
            if (degree > degreeMax) degreeMax = degree;
        }
        return degreeMax;
    }

    public int inDegree(int i) { 
        int degree = 0;
        for (int j = 0; j < numV; j++) 
            if (existsEdge(j, i)) degree++;  
        return degree;
    }
       
    private int[] getArrayInDegrees() {
        // create and initialize the counter array
        int[] inDegree = new int[numV];
        for (int i = 0; i < numV; i++) {
            // update the counter of the Input degree
            // of each vertex in the AdjacentListFrom(i) 
            ListPOI<Adjacent> l = theArray[i];
            for ( l.begin(); !l.isEnd(); l.next()) {
                inDegree[l.get().getTarget()]++;
            }
        }
        return inDegree;
    }
    
    public int inDegree() { 
            int[] inDegree = getArrayInDegrees();
            // for all i : 0 <= i < numV : 
            // inDegree[i] is the Input degree of i
            int degreeMax = inDegree[0];
            for (int i = 1; i < numV; i++) { 
                int degree = inDegree[i]; 
                if (degree > degreeMax) degreeMax = degree; 
            }
            return degreeMax;
        }
    
        public int[] toArrayDFS() {
            int[] res = new int[numVertices()]; 
            orderVisited = 0;
            visited = new int[numVertices()];
            for (int v = 0; v < numVertices(); v++) {  
                if (visited[v] == 0) toArrayDFS(v, res);
            }
            return res;
        } 
    
        protected void toArrayDFS(int v, int[] res) { 
            res[orderVisited] = v; 
            orderVisited++; 
            visited[v] = 1;
            ListPOI<Adjacent> l = adjacentsTo(v);
            for (l.begin(); !l.isEnd(); l.next()) {
                int w = l.get().getTarget();
                if (visited[w] == 0) toArrayDFS(w, res);
            }
        }  
    
        public int[] toArrayBFS() {
            int[] res = new int[numVertices()]; 
            visited = new int[numVertices()];
            orderVisited = 0; 
            q = new ArrayQueue<Integer>(); 
            for (int v = 0; v < numVertices(); v++) { 
                if (visited[v] == 0) toArrayBFS(v, res); 
            }
            return res;
        }  
    
        protected void toArrayBFS(int v, int[] res) { 
            visited[v] = 1; 
            res[orderVisited++] = v; 
            q.enqueue(v);
            while (!q.isEmpty()) {
                int u = q.dequeue(); 
                ListPOI<Adjacent> l = adjacentsTo(u);
                for (l.begin(); !l.isEnd(); l.next()) {
                    int w = l.get().getTarget();
                    if (visited[w] == 0) { 
                        visited[w] = 1; 
                        res[orderVisited++] = w; 
                        q.enqueue(w);
                    }
                } 
            }
        }
    
        // "auxiliary" attributes
        protected double[] minLength; 
        protected int[] minPath; 
        protected static final double INFINITY = Double.POSITIVE_INFINITY; 
    
        public void minimumPathWithoutWeights(int v) {
            minPath = new int[numVertices()]; 
            minLength = new double[numVertices()];
            for (int i = 0; i < numVertices(); i++) { 
                minLength[i] = INFINITY;
                minPath[i] = -1;        
            } 
            minLength[v] = 0;
            q = new ArrayQueue<Integer>(); 
            q.enqueue(v);
            while (!q.isEmpty()) {
                int u = q.dequeue(); 
                ListPOI<Adjacent> l = adjacentsTo(u);
                for (l.begin(); !l.isEnd(); l.next()) {
                    int w = l.get().getTarget();
                    if (minLength[w] == INFINITY) { 
                        minLength[w] = minLength[u] + 1; 
                        minPath[w] = u; 
                        q.enqueue(w);
                    }
                }
            }
        }  
    
        /** IFF v != w AND 0 <= v < numVertices() AND 0 <= w < numVertices() 
         * returns a ListPOI with the vertices of the minimum path 
         * NO weights between v and w, or an empty list if such a path does not exist. 
         */
        public ListPOI<Integer> minimumPathWithoutWeights(int v, int w) { 
            minimumPathWithoutWeights(v);
            return decodePathTo(w);
        }
    
        // IFF 0 <= w < numVertices().
        // return a ListPOI with the vertices of the path to w 
        protected ListPOI<Integer> decodePathTo(int w) {
            ListPOI<Integer> res = new LinkedListPOI<Integer>();
            if (minLength[w] != INFINITY) {
                res.add(w);
                for (int v = minPath[w]; v != -1; v = minPath[v]) {
                    res.begin();
                    res.add(v);
                }
            }        
            return res;
        }

    
        /** IFF v != w AND 0 <= v < numVertices() AND 0 <= w < numVertices() 
         * returns a ListPOI with the vertices of the path. 
         * minimum WITH weights between v and w, or an empty list if.
         * such a path does not exist */
        public ListPOI<Integer> minPath(int v, int w) { 
            dijkstra(v);
            return decodePathTo(w);
        }
    
        public void dijkstra(int u) {
            minLength = new double[numVertices()]; 
            minPath = new int[numVertices()];        
            for (int i = 0; i < numVertices(); i++) {
                minLength[i] = INFINITY; 
                minPath[i] = -1; 
            }
            minLength[u] = 0;
            visited = new int[numVertices()];
            PriorityQueue<VertexCost> pQ;
            pQ = new BinaryHeap<VertexCost>(); 
            pQ.add(new VertexCost(u, 0));
            // as long as there are vertices to be explored
            while (!pQ.isEmpty()) { 
                // next vertex to be explored is the one with the shortest path
                int v = pQ.removeMin().code;
                if (visited[v] == 0) { // avoid repetitions
                    visited[v] = 1; 
                    // traverse adjacent vertices of v
                    ListPOI<Adjacent> l = adjacentsTo(v);
                    for (l.begin(); !l.isEnd(); l.next()) {
                        int w = l.get().getTarget();
                        double costW = l.get().weight;
                        // best way to reach w is through v ?
                        if (minLength[w] > minLength[v] + costW) {
                            minLength[w] = minLength[v] + costW; 
                            minPath[w] = v;
                            pQ.add(new VertexCost(w, minLength[w]));  
                        }
                    }
                }
            }
        }
    
        /* IFF the Graph is a DAG */
        public int[] topologicalOrderDFS() {
            int[] res = new int[numVertices()]; 
            orderVisited = 0;
            visited = new int[numVertices()];
            for (int v = 0; v < numVertices(); v++) {
                if (visited[v] == 0) topologicalOrderDFS(v, res);  
            }
            return res;
        }
    
        protected void topologicalOrderDFS(int v, int[] res) { 
            visited[v] = 1;
            ListPOI<Adjacent> l = adjacentsTo(v);
            for (l.begin(); !l.isEnd(); l.next()) {
                int w = l.get().getTarget();
                if (visited[w] == 0) topologicalOrderDFS(w, res);         
            }
            visited[v] = 2;
            res[numVertices() - 1 - orderVisited] = v; 
            orderVisited++;
        }  

        // IFF the Graph is a Digraph ...
        public boolean cycleDFS() {
            boolean cycle = false; 
            visited = new int[numVertices()];
            for (int v = 0; v < numVertices() && !cycle; v++) 
                if (visited[v] == 0) cycle = existsBackEdgeDFS(v); 
            return cycle;
        }
    
        protected boolean existsBackEdgeDFS(int v) { 
            boolean backEdge = false; 
            visited[v] = 1;
            ListPOI<Adjacent> l = adjacentsTo(v);
            for (l.begin(); !l.isEnd() && !backEdge; l.next()) {
                int w = l.get().getTarget();
                if (visited[w] == 0) backEdge = existsBackEdgeDFS(w); 
                else if (visited[w] == 1) backEdge = true;          
            }
            visited[v] = 2;
            return backEdge;
        }  

        // IFF the Graph is Directed ...
        public int[] cycleAndTopologicalOrderDFS() {
            int[] res = new int[numVertices()]; 
            orderVisited = 0; 
            visited = new int[numVertices()]; 
            boolean cycle = false; 
            for (int v = 0; v < numVertices() && !cycle; v++) {
                if (visited[v] == 0) cycle = cycleAndTopologicalOrderDFS(v, res); 
            }
            if (!cycle) return res; 
            return null; 
        }
    
        protected boolean cycleAndTopologicalOrderDFS(int v, int[] res) { 
            boolean backEdge = false; 
            visited[v] = 1; 
            ListPOI<Adjacent> l = adjacentsTo(v);
            for (l.begin(); !l.isEnd() && !backEdge; l.next()) {
                int w = l.get().getTarget();
                if (visited[w] == 0) {
                    backEdge = cycleAndTopologicalOrderDFS(w, res);
                }
                else if (visited[w] == 1) {
                    backEdge = true;
                }
            }
            visited[v] = 2;
            res[numVertices() - 1 - orderVisited] = v; 
            orderVisited++;
            return backEdge;
        }

        public int degree(){
            int[] degreeV = getArrayDegrees();
            return maxV(degreeV);
        }

        private int maxV(int[] degreeV) {
            int max = degreeV[0];
            for(int i = 0; i < degreeV.length; i++){
                if(degreeV[i] > max){
                    max = degreeV[i];
                }
            }
            return max;
        }

        protected int[] getArrayDegrees(){
            int[] degrees = new int[numV];
            for(int i = 0; i < numV; i++){
                ListPOI<Adjacent> l = theArray[i];
                degrees[i] += l.size();

                for(l.begin(); !l.isEnd(); l.next()){
                    degrees[l.get().getTarget()]++;
                }
            }
            return degrees;
        }

        public double maxWeightEdge(){
            double res = -1;
            for(int i = 0; i < numV; i++){
                ListPOI<Adjacent> l = theArray[i];
                for(l.begin(); !l.isEnd(); l.next()){
                    double a = l.get().getWeight();
                    if(a > res){res = a;}
                }
            }
            return res;
        }

        public boolean isRegular(){
            int[] degreeV = getArrayDegrees();
            int degreeV0 = degreeV[0];
            for(int i = 1; i < numV; i++){
                if(degreeV[i] != degreeV0){return false;}
            }
            return true;
        }
    }