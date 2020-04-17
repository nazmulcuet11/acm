class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return a list of integers
    def twoSum(self, a, target):
        mem = {}
        idx1, idx2 = -1, -1
        for i in range(len(a)):
            r = target - a[i]
            if r in mem:
                idx = mem[r]
                s = min(idx, i)
                t = max(idx, i)
                if idx1 == -1 or t < idx2:
                    idx1, idx2 = s, t
            if a[i] not in mem:
                mem[a[i]] = i

        if idx1 != -1:
            return [idx1 + 1, idx2 + 1]
        return []

print(Solution().twoSum([4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8], -3))