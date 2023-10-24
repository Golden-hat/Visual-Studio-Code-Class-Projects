final_state = "123804765"

def swap(state, index1, index2):
    state_list = list(state)
    aux = state_list[index1]
    state_list[index1] = state_list[index2]
    state_list[index2] = aux
    state = "".join(state_list)
    
def isMisplaced(index, state):
    if state[index] != final_state[index]:
        return True
    return False

def printState(state):
    print(state[0:2])
    print(state[0:2])
    print(state[0:2])

def maxSwap(state):
    stateCopy = state
    moves = 0

    if int(stateCopy[4]) == 0:
        swap(stateCopy, 1, 2)
        moves += 1

    isOrdered = False

    for i in range(0,8):
        if isMisplaced(i, stateCopy) and stateCopy[i] != 0:
            pos = stateCopy.find("0")
            swap(stateCopy, pos, i)

            moves += 1
    
        if stateCopy == final_state:
            continue

    state = stateCopy
    return moves

print(maxSwap("123408765"))