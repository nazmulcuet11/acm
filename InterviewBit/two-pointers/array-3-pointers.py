class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @param C : tuple of integers
    # @return an integer
    def minimize(self, A, B, C):
        i, j, k = 0, 0, 0
        ans = 2**31-1
        while i < len(A) and j < len(B) and k < len(C):
            x = abs(A[i] - B[j])
            y = abs(B[j] - C[k])
            z = abs(C[k] - A[i])

            mx = max(x, y, z)
            ans = min(ans, mx)
            if x == mx:
                if A[i] < B[j]:
                    i += 1
                else:
                    j += 1
            elif y == mx:
                if B[j] < C[k]:
                    j += 1
                else:
                    k += 1
            else:
                if C[k] < A[i]:
                    k += 1
                else:
                    i += 1
        
        return ans


print(Solution().minimize([1, 4, 10], [2, 15, 20], [10, 12]))