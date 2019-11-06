def findIndex(arr, x):
    l, r = 0, len(arr) - 1
    while  l < r:
        m = int((l + r + 1) / 2)
        if arr[m] > x:
            r = m - 1
        else:
            l = m

    return l if arr[l] <= x else (l - 1)

class Solution:
    # @param arrive : list of integers
    # @param depart : list of integers
    # @param K : integer
    # @return a boolean


    def hotel(self, arrive, depart, K):
        arrive.sort()
        depart.sort()
        for i in range(len(arrive)):
            x = findIndex(depart, arrive[i])
            if i - x > K:
                return False
        return True

        


# print(Solution().hotel([1, 5, 3], [2, 8, 6], 1))
# print(Solution().hotel([ 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 ],
# [ 28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53 ], 23))
print(Solution().hotel([1, 2, 3], [2, 3, 4], 1))

