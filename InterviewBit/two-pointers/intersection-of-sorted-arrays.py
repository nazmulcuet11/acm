class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @return a list of integers
    def intersect(self, A, B):
        counter = {}
        for n in A:
            if n in counter:
                counter[n] += 1
            else:
                counter[n] = 1

        ans = []
        for n in B:
            if n in counter and counter[n] > 0:
                ans.append(n)
                counter[n] -= 1

        return ans

class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @return a list of integers
    def intersect(self, A, B):
        i, j = 0, 0
        ans = []
        while i < len(A) and j < len(B):
            if A[i] == B[j]:
                ans.append(A[i])
                i += 1
                j += 1
            elif A[i] < B[j]:
                i += 1
            else:
                j += 1

        return ans


print(Solution().intersect([1, 2, 3, 3, 4, 5, 6], [3, 3, 5]))