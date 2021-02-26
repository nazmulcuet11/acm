class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):
        sum = 0
        hash = {}
        max_len = 0

        for idx, v in enumerate(A):
            if v == 0:
                sum -= 1
            else:
                sum += 1

            if sum == 1:
                max_len = idx + 1
            else:
                if sum not in hash:
                    hash[sum] = idx
                if sum - 1 in hash:
                    l = hash[sum - 1]
                    # l] to idx] sum == 1
                    max_len = max(max_len, idx - l)
        return max_len


print(Solution().solve([0, 1, 1, 0, 0, 1]))
print(Solution().solve([1, 0, 0, 1, 0]))
