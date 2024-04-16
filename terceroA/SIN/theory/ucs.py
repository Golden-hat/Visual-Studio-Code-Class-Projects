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

G2={'A':[('B',1),('C',4)],
    'B':[('A',1),('C',1),('D',3)],
    'C':[('A',4),('B',1),('E',1)],
    'D':[('B',3),('E',1)],
    'E':[('C',1),('D',1)]
}

def djikstra(G, s, t):

    # Cd = visited nodes
    # Oh = priority queue
    # Od = adjacents

    Od = {s:0}

    Cd = {}
    Oh = []; heapq.heappush(Oh, (0, s, [s]))

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
            gs, s, path = heapq.heappop(Oh)

            # If we detect that the current node is the goal node, we return from the method with
            # The weight of the path and the sequence to follow
            if s == t: return gs, path

            # Next, we will delete from Od the node we have traveled to.
            # Then we will create a dictionary that pairs the weight of a node with its name (Name = key)
            # This dictionary marks the visited nodes
            del Od[s]; Cd[s] = gs

            for n, wsn in G[s]:
                print("we're in: "+s)
                print("Adjacent "+n+", from "+s)
                print("We have already visited these nodes: "); print(Cd)
                if n in Cd:
                    print("We have already visited "+ n)
                # We sum the total weight we're carrying so far + the current potentially visited adjacent node weight
                gn = gs + wsn

                # If the node we're planning on going to has not yet been visited, and (it is not present in the
                # Adjacent list or if the current weight is less than that of the potential node), we put it in the 
                # queue updating the total weight, our new node, and we add the path following to it

                # additionally we put the new adjacents in the list. As it is a dictionary, it will detect
                # whenever we want to update one of its entries

                if n not in Cd and (n not in Od or gn < Od[n]):
                    print("Node "+n+ " will be added to the heap and to the Adjacency list")
                    heapq.heappush(Oh, (gn, n, path+[n]))
                    Od[n] = gn
                print("Our current adjacency list (considering previous weights) is the following:")
                print(Od)
            print()

print(djikstra(G2, 'A', 'C'))
                


