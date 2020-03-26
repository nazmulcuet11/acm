class Solution:
    # @param A : list of integers
    # @param B : list of integers
    def merge(self, A, B):
        i, j= 0, 0
        ans = []
        while i < len(A) and j < len(B):
            if A[i] <= B[j]:
                ans.append(A[i])
                i += 1
            else:
                ans.append(B[j])
                j += 1
        
        while i < len(A):
            ans.append(A[i])
            i += 1
        
        while j < len(B):
            ans.append(B[j])
            j += 1

        return ans

print(Solution().merge([-4, 3], [-2, -2]))