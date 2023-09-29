# Uniform-cost algorithm, or the DJIKSTRA ALGORITHM enumerates paths
# until finding a solution by prioritizing paths with minimum partial
# cost and avoiding cycles

import heapq

G={'A':[('B',1),('C',4)],'B':[('A',1),('D',1)], 'C':[('A',4),('E',1)],'D':[('B',1),('E',4)], 'E':[('C',1),('D',4)]}

h = {'A':5,'B':5,'C':1,'D':4,'E':0}

def astar(G, s, t, h):

    # Cd = visited nodes
    # Oh = priority queue
    # Od = adjacents

    Od = {s:0}

    Cd = {}
    Oh = []; heapq.heappush(Oh, (h[s], s, [s]))

    # We have stored in Od the first element with base weight, 0 by default.
    # In Oh we have initialized the priority queue in which we'll store current node's adjacents.
    # Od will keep track of the adjacents to the node we're currently visiting (accounting previous weights).

    while Od:
        s = None
        # s is initialized to NULL, so that it takes the value of any of the adjacent nodes to the starting node.
        while s not in Od:

            # We take out the data from the current node that is stored in the heap

            # Notice that python does a "cool thing", in which if an element is comprised 
            # of 3 elements, accessing them in the fashion "a, b, c = element" will store them
            # each in their respective a, b, c variables.
            s, path = heapq.heappop(Oh)

            gs = Od[s]

            # If we detect that the current node is the goal node, we return from the method with
            # The weight of the path and the sequence to follow
            if s == t: return gs, path

            # Next, we will delete from Od the node we have traveled to.
            # Then we will create a dictionary that pairs the weight of a node with its name (Name = key)
            # This dictionary marks the visited nodes
            del Od[s]; Cd[s] = gs

            for n, wsn in G[s]:
                gn = gs + wsn
                if n in Cd:
                    if gn < Cd[n]: del Cd[n]
                    else: continue
                elif n in Od and gn >= Od[n]: continue

                heapq.heappush(Oh, (gn+h[n], n, path+[n]))
                Od[n] = gn

print(astar(G, 'A', 'E', h))