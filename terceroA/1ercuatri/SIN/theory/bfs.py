from queue import Queue

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

G={'A':['B','C'],'B':['A','D'],'C':['A','E'],'D':['B','E'],'E':['C','D']}

def BFS(G, s, t):

    visitedNodes = []
    pQ = Queue(); pQ.put((s, [s]))

    while pQ:
        currentNode, path = pQ.get()
        visitedNodes.append(currentNode)
        if currentNode == t: return path

        print(currentNode)
        print(path)
        
        for i, j in G[currentNode]:
            if i not in visitedNodes:
                pQ.put((i, path+[i]))


print(BFS(G1, 'A', 'D'))


