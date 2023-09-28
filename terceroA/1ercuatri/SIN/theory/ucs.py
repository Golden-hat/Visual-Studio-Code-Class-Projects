# Uniform-cost algorithm, or the DJIKSTRA ALGORITHM enumerates paths
# until finding a solution by prioritizing paths with minimum partial
# cost and avoiding cycles

import heapq

G1={
    'A':[('B',1),('C',4)],
    'B':[('A',1),('D',1)],
    'C':[('A',4),('E',1)],
    'D':[('B',1),('E',1)],
    'E':[('C',1),('D',1)]
}

def djikstra(G, s, t):
    Od = {s:0}

    Cd = {}
    Oh = []; heapq.heappush(Oh, (0, s, [s]))

    # We have stored in Od the first element with base weight, 0 by default.
    # In Oh we have initialized the priority queue in which we'll store current node's adjacents.

    # Od will keep track of the adjacents to node we're currently visiting.

    while Od:
        s = None
        # s is initialized to NULL, so that it takes the value of any of the adjacent nodes to the starting node.
        while s not in Od:
            print(Od)
            print(Oh)

            # We take out the data from the current node that is stored in the heap

            # Notice that python does a "cool thing", in which if an element is comprised 
            # of 3 elements, accessing them in the fashion "a, b, c = element" will store them
            # each in their respective a, b, c variables.

            gs, s, path = heapq.heappop(Oh)

            # If we detect that the current node is the goal node, we return from the method with
            # The weight of the path and the sequence to follow
            if s == t: return gs, path

            # Next, we will delete from Od the node we have traveled to.
            # Then we will create a dictionary that pairs the weight of a node with its name (Name = key)
            # This dictionary marks the visited nodes

            del Od[s]; Cd[s] = gs
            print(Cd)

            for n, wsn in G[s]:
                # We sum the total weight we're carrying so far + the current potentially visited adjacent node weight
                gn = gs + wsn

                # If the node we're planning on going to has not yet been visited, and it is not present in the
                # or if the current weight is less than that of the potential node, we put it in the queue
                # updating the total weight, our new node, and we add the path following to it

                # additionally we put the new adjacents in the list
                if n not in Cd and (n not in Od or gn < Od[n]):
                    print("dentro")
                    heapq.heappush(Oh, (gn, n, path+[n]))
                    print(Od)
                    Od[n] = gn
            print()

print(djikstra(G1, 'A', 'E'))
                


