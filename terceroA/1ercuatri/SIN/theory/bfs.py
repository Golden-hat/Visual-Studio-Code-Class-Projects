import heapq

G1={
    'A':[('B',1),('C',4)],
    'B':[('A',1),('D',1)],
    'C':[('A',4),('E',1)],
    'D':[('B',1),('E',1)],
    'E':[('C',1),('D',1)]
}

G2={'A':[('B',1),('C',4)],
    'B':[('A',1),('C',1),('D',3)],
    'C':[('A',4),('B',1),('E',1)],
    'D':[('B',3),('E',1)],
    'E':[('C',1),('D',1)]
}

def BFS(G, s, t):

    visitedNodes = []
    pQ = []; heapq.heappush(pQ, (s, G[s]))
    
    path = []

    while s != t:
        currentNodeAdjacents = heapq.heappop(pQ)
        print(currentNodeAdjacents)
        for i, j in currentNodeAdjacents:
            if j not in visitedNodes: 
                visitedNodes.append(i)
                heapq.heappush(pQ, (i, G[i]))


BFS(G1, 'A', 'D')


