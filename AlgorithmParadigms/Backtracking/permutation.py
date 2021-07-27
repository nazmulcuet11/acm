a = [1, 2, 3]
r = 2

print("permutation without repeatation")
taken = [False] * len(a)
def permutaionWithoutRep(t):
    if len(t) == r:
        print(t)
        return
    
    for i in range(len(a)):
        if not taken[i]:
            taken[i] = True
            permutaionWithoutRep(t + [a[i]])
            taken[i] = False

permutaionWithoutRep([])

print("permutation with repeatation")
def permutaionWithRep(t):
    if len(t) == r:
        print(t)
        return

    for i in range(len(a)):
        permutaionWithRep(t + [a[i]])

permutaionWithRep([])

print("permutation with k repeatation")
k = 1
rem = [k] * len(a)
def permutaionWithKRep(t):
    if len(t) == r:
        print(t)
        return

    for i in range(len(a)):
        if rem[i] > 0:
            rem[i] -= 1
            permutaionWithKRep(t + [a[i]])
            rem[i] += 1


permutaionWithKRep([])
