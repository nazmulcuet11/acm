def nextGreaterElement(array):
    mxIdx = 0  # index of max element
    for i, v in enumerate(array):
        if v > array[mxIdx]:
            mxIdx = i

    n = len(array)
    ans = [-1 for _ in range(n)]
    stk = [mxIdx]
    k = mxIdx - 1 # start at maxIdx - 1 and work backwords
    for _ in range(n-1):
        k = (k + n) % n
        while len(stk) > 0 and array[stk[-1]] <= array[k]:
            stk.pop()
        if len(stk) > 0:
            ans[k] = array[stk[-1]]
        stk.append(k)
        k -= 1
    return ans


# [2, 5, -3, -4, 6,  7, 2]
# [5, 6,  6,  6, 7, -1, 5]
print(nextGreaterElement([2, 5, -3, -4, 6, 7, 2]))

