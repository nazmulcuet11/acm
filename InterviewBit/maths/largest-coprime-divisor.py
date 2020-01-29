def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

class Solution:
	# @param A : integer
	# @param B : integer
	# @return an integer
    def cpFact(self, A, B):
        i, ans =  1, -1
        while (i * i) <= A:
            if A % i == 0:
                if gcd(i, B) == 1:
                    ans = max(ans, i)
                if gcd(A / i, B) == 1:
                    return int(A / i)
                    # ans = max(ans, A / i)
            i += 1
        return int(ans)

print(Solution().cpFact(2, 3))