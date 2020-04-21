import heapq

class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return a list of integers
    def solve(self, a, b):
        a = sorted(a)
        b = sorted(b)
        l = len(a) - 1
        s = a[l] + b[l]
        h = [(-s, (l, l))]
        heapq.heapify(h)
        ans = []
        seen = {}
        while len(ans) < len(a) and len(h) > 0:
            sum, (x, y) = heapq.heappop(h)
            if (x, y) in seen:
                continue
            seen[(x, y)] = True
            ans.append(-sum) 
            if x > 0: 
                s = a[x - 1] + b[y]
                heapq.heappush(h, (-s, (x - 1, y)))
            if y > 0:
                s = a[x] + b[y - 1]
                heapq.heappush(h, (-s, (x, y - 1))) 
        return ans

print(Solution().solve([1, 4, 2, 3], [2, 5, 1, 6]))