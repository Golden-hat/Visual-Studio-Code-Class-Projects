from queue import Queue

G={'A':['B','C'],'B':['A','D'],'C':['A','E'],'D':['B','E'],'E':['C','D']}

def dfs(G, s, t, path):
    print(s)
    print(path)
    if s == t : return path

    for i in G[s]:
       if i not in path:
        # We use return here to keep the stack level at zero. Otherwise,
        # we would go down and down until we found our solution, from which we would have to go up again
        # completing the lasting iterations of the for loop
        return dfs(G, i, t, path+[i])

print(dfs(G, 'A', 'E', ['A']))    