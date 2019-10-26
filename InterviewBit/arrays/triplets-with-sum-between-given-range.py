class Solution:
	# @param A : list of strings
	# @return an integer
    def solve(self, A):
        x = [float(A[i]) for i in range(len(A))]
        x.sort()
        i, j = 0, len(x)-1
        while i + 1 < j:
            t = x[i] + x[i+1] + x[j]
            if 1 < t and t < 2:
                return 1
            elif t >= 2:
                j -= 1
            else:
                i += 1 
        return 0

print(Solution().solve(["0.6", "0.7", "0.8", "1.2", "0.4"]))
print(Solution().solve([ "0.038089", "0.345795", "0.226426", "0.236377", "0.022112", "0.205749", "0.251645", "0.176912", "0.385263", "0.343043" ]))
