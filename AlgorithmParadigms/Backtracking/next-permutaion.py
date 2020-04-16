def next_permutation(a):
    i = len(a) - 2
    while i >=0 and a[i] >= a[i+1]:
        i -= 1
    if i < 0:
        return None
    for j in range(len(a)-1, i, -1):
        if a[j] > a[i]:
            a[i], a[j] = a[j], a[i]
            a[i+1: len(a)] = sorted(a[i+1:len(a)])
            break
    return a

a = [2, 2, 3, 3]
print(a)
while True:
    next = next_permutation(a)
    print(next)
    if not next:
        break
    a = next
