class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @param C : list of integers
    # @return an integer
    def solve(self, A, B, C):
        i, j, k = 0, 0, 0
        ans = 2**31-1
        while i < len(A) and j < len(B) and k < len(C):
            mn = min(A[i], B[j], C[k])
            mx = max(A[i], B[j], C[k])
            ans = min(ans, mx - mn)
            if A[i] == mn:
                i += 1
            elif B[j] == mn:
                j += 1
            else:
                k += 1

        return ans


print(Solution().solve([1, 4, 5, 8, 10], [6, 9, 15], [2, 3, 6, 6]))