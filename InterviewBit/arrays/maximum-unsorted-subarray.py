class Solution:
    # @param A : list of integers
    # @return a list of integers
    def subUnsort(self, A):
        A = [0] + A +  [A[-1]]

        broken_min = -1
        for i in range(1, len(A)):
            if A[i] < A[i-1]:
                broken_min = A[i]
                for j in range(i+1, len(A)):
                    broken_min = min(broken_min, A[j])
                break
        
        left_index = -1
        if broken_min != -1:
            for j in range(1, len(A)):
                if A[j] > broken_min:
                    left_index = j
                    break

        broken_max = -1
        for i in range(len(A)-2, 0, -1):
            if A[i] > A[i+1]:
                broken_max = A[i]
                for j in range(i-1, 0, -1):
                    broken_max = max(broken_max, A[j])
                break

        right_index = -1
        if broken_max != -1:
            for j in range(len(A)-2, 0, -1):
                if A[j] < broken_max:
                    right_index = j
                    break


        if left_index != -1 and right_index != -1:
            return [left_index-1, right_index-1]        
        return [-1]

print(Solution().subUnsort([1, 3, 2, 4, 5]))
print(Solution().subUnsort([ 1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18]))