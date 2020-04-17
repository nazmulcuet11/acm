class Solution:
    # @param A : list of integers
    # @return a list of integers
    def lszero(self, a):
        mem = {0: -1}
        sum = 0
        x, y = -1, -1
        max_diff = -1
        for i in range(len(a)):
            sum += a[i]
            if sum in mem:
                diff = i - mem[sum]
                if diff > max_diff:
                    max_diff = diff
                    x, y = mem[sum], i
            else:
                mem[sum] = i
        ans = []
        for i in range(x + 1, y + 1):
            ans.append(a[i])
        return ans

print(Solution().lszero([]))
print(Solution().lszero([1 ,2 ,-2 ,4 ,-4]))
print(Solution().lszero([1, 2, -3, 3]))
