class Solution:
    # @param A : list of integers
    # @return a list of integers
    def wave(self, A):
        A.sort()
        evenInedxes = [i for i in range(0, len(A), 2)]
        oddIndexes = [i for i in range(1, len(A), 2)]
        ans = []
        for i in range(len(oddIndexes)):
            ans.append(A[oddIndexes[i]])
            ans.append(A[evenInedxes[i]])

        if len(oddIndexes) < len(evenInedxes):
            ans.append(A[evenInedxes[-1]])

        return ans


print(Solution().wave([1, 2, 3, 4, 5, 6]))
print(Solution().wave([6, 0, 6, 12]))