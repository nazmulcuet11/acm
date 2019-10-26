from functools import cmp_to_key

class Solution:
    # @param A : tuple of integers
    # @return a strings
    def comp(self, a, b):
        if a + b > b + a:
            return -1
        elif a + b < b + a:
            return 1
        else:
            return 0

    def largestNumber(self, A):
        ans = ''.join(sorted(map(str, A), key=cmp_to_key(self.comp))).lstrip("0")
        return ans if len(ans) > 0 else "0"


print(Solution().largestNumber([3, 30, 34, 5, 9]))
print(Solution().largestNumber([0, 0, 0, 0, 0]))