a = [1, 2, 3, 4]
r = 3

print("combination without repeatation")
taken = [False] * len(a)


def combinationWithoutRep(i, t):
    if len(t) == r:
        print(t)
        return
    if i >= len(a):
        return

    # we can either take a[i] or not take it
    combinationWithoutRep(i + 1, t + [a[i]])
    combinationWithoutRep(i + 1, t)

combinationWithoutRep(0, [])

print("combination with repeatation")
def combinationWithRep(i, t):
    if len(t) == r:
        print(t)
        return
    if i >= len(a):
        return

    # if we take a[i] we can again choose to take a[i]
    combinationWithRep(i, t + [a[i]])
    # if we do not take a[i] we can not take element before i again
    # because that will lead to permutation
    combinationWithRep(i + 1, t)

combinationWithRep(0, [])

print("combination with k repeatation")
k = 2
rem = [k] * len(a)
def combinationWithKRep(i, t):
    if len(t) == r:
        print(t)
        return
    if i >= len(a):
        return

    # if we take a[i] we can again choose to take a[i]
    if rem[i] > 0:
        rem[i] -= 1
        combinationWithKRep(i, t + [a[i]])
        rem[i] += 1
    # if we do not take a[i] we can not take element before i again
    # because that will lead to permutation
    combinationWithKRep(i + 1, t)


combinationWithKRep(0, [])
