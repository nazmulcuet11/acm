from collections import deque

class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return a list of integers
    def slidingMaximum(self, arr, k):
        d = deque()
        for i in range(min(k, len(arr))):
            while len(d) > 0 and arr[d[-1]] <= arr[i]:
                d.pop()
            d.append(i)

        ans = [arr[d[0]]]
        for i in range(k, len(arr)):
            while len(d) > 0 and d[0] <= i - k:
                d.popleft()
            while len(d) > 0 and arr[d[-1]] <= arr[i]:
                d.pop()
            d.append(i)
            ans.append(arr[d[0]])
        return ans

print(Solution().slidingMaximum([1, 3, -1, -3, 5, 3, 7, 6], 9))

