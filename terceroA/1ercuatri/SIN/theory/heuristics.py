import time
final_state = "123804765"

def swap(state, index1, index2):
    state_list = list(state)
    aux = state_list[index1]
    state_list[index1] = state_list[index2]
    state_list[index2] = aux
    state = "".join(state_list)
    printState(state)

    return state
    
def isMisplaced(index, state):
    if state[index] != final_state[index]:
        return True
    return False

def printState(state):
    print(state[0:3])
    print(state[3:6])
    print(state[6:9])
    print()

def maxSwap(state):
    stateCpy = state
    moves = 0
    if int(state[4]) == 0:
        for i in range(0, 9):
            if isMisplaced(i, state):
                state = swap(state, i, 4)
                moves += 1
                break
    
    while(state != final_state):
        for i in range(0,9):
            if isMisplaced(i, state):
                pos = state.find("0")
                if state[i] == final_state[pos]: 
                    state = swap(state, pos, i)    
                    moves += 1

        if state == final_state:
            break

    state = stateCpy
    return moves

print(maxSwap("023845716"))
print()

def nSwap(state):
    stateCpy = state
    moves = 0
    while(state != final_state):
        for i in range(0,9):
            if isMisplaced(i, state):
                pos = final_state.find(state[i])
                state = swap(state, pos, i)

                moves += 1
        
            if state == final_state:
                break

    state = stateCpy
    return moves

print(nSwap("123408765"))