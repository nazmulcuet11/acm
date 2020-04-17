class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of list of integers
    def fourSum(self, a, target):
        a = sorted(a)
        mem = {}
        ans = set()
        for i in range(len(a)):
            for j in range(i + 1, len(a)):
                s = a[i] + a[j]
                r = target - s
                if r in mem:
                    for x, y in mem[r]:
                        if y >= i:
                            continue
                        ans.add((a[x], a[y], a[i], a[j]))
                if s in mem:
                    mem[s].append((i, j))
                else:
                    mem[s] = [(i, j)]
        ans = list(ans)
        return sorted(ans)

print(Solution().fourSum([1, 0, -1, 0, -2, 2], 0))
        
