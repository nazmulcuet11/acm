class Solution:
    # @param A : list of integers
    # @return a list of integers
    def solve(self, A):
        hash = {}
        for idx, v in enumerate(A):
            if v in hash:
                min_idx = hash[v]
                new_val = A[min_idx] + 1
                # update
                A[min_idx] = new_val
                hash[new_val] = min(hash.get(new_val, len(A)), min_idx)

            hash[v] = idx
        return A


print(Solution().solve([1, 2, 3, 2, 3, 1, 4, 2, 1, 3]))
