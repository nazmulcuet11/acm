class Solution:
    # @param A : list of integers
    # @param B : integer
    # @param C : integer
    # @return an integer
    def solve(self, A, B, C):
        C -= 1
        digits_of_c = []
        while C:
            digits_of_c.append(C % 10)
            C //= 10

        if len(digits_of_c) == 0:
            digits_of_c.append(0)

        if len(digits_of_c) < B:
            return 0

        allowed = [0]*10
        for num in A:
            allowed[num] += 1

        lower = [0]*10
        for i in range(1, 10):
            lower[i] += lower[i-1] + allowed[i-1]

        total_digits = len(A)
        full_set = [0]*B
        full_set[0] = total_digits
        for i in range(1, B):
            full_set[i] = full_set[i-1]*total_digits

        if len(digits_of_c) > B:
            ans = full_set[B-1]
            if B > 1 and allowed[0]:
                ans -= full_set[B-2]
            return ans

        dp = [0]*B
        # Base case: For a given digit 'd' (i.e. only one digit number) 
        # we can generate all numbers that are less than or equal to 'd'
        dp[0] = lower[digits_of_c[0]] + allowed[digits_of_c[0]]
        for i in range(1, B):
            digit = digits_of_c[i]
            # for a digit 'd' we can generate full set * number of digit less than 'd'
            dp[i] = lower[digit]*full_set[i-1]
            # if given digit 'd' is valid then we can generate 
            # additional dp[i-1] numbers by placing 'd' at ith position 
            if allowed[digit]:
                dp[i] += dp[i-1]

        ans = dp[B-1]
        if B > 1 and allowed[0]:
            ans = max(0, ans - full_set[B-2])

        return ans

print(Solution().solve([2, 9], 5, 17015))
print(Solution().solve([0, 1, 2, 5], 1, 1))
print(Solution().solve([0, 1, 2, 5], 2, 21))
print(Solution().solve([0, 1, 2, 5], 3, 221))