from queue import Queue

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
        
        for i in G[currentNode]:
            if i not in visitedNodes:
                pQ.put((i, path+[i]))


print(BFS(G, 'A', 'D'))


