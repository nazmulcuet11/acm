class Solution:
    # @param A : integer
    # @return an integer
    def computeGCD(self, x, y): 
        while(y): 
            x, y = y, x % y 
        return x

    def isPower(self, A):
        if A == 1:
            return 1
        i = 2
        factor_counts = []
        while i * i <= A:
            if A % i == 0:
                cnt = 0
                while A % i == 0:
                    A /= i
                    cnt += 1
                # print(i)
                # print(cnt)
                factor_counts.append(cnt)
            i += 1

        if A > 1:
            return 0

        if len(factor_counts) == 0:
            return 0

        # print(factor_counts)
        __gcd = factor_counts[0]
        for i in range(1, len(factor_counts)):
            __gcd = self.computeGCD(__gcd, factor_counts[i])
        
        if __gcd > 1:
            return 1
        return 0

print(Solution().isPower(4))