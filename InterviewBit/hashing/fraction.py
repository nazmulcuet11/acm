class Solution:
    # @param A : integer
    # @param B : integer
    # @return a strings
    def fractionToDecimal(self, a, b):
        if a % b == 0:
            return str(a // b)

        cache = {}
        ans = []
        if a * b < 0:
            ans.append('-')

        a = abs(a)
        b = abs(b)

        q = a // b
        a = a % b
        a *= 10
        ans.append(str(q))
        ans.append('.')

        while a:
            if a in cache:
                ans.insert(cache[a], "(")
                ans += ")"
                break

            cache[a] = len(ans)

            if a < b:
                ans.append('0')
            else:
                q = a // b
                a = a % b
                ans.append(str(q))
            a *= 10

        return ''.join(ans)


print(Solution().fractionToDecimal(1, 2))
print(Solution().fractionToDecimal(2, 1))
print(Solution().fractionToDecimal(2, 3))
print(Solution().fractionToDecimal(1, 3))
print(Solution().fractionToDecimal(22, 7))
print(Solution().fractionToDecimal(1, 1000))
print(Solution().fractionToDecimal(1, -2))
print(Solution().fractionToDecimal(857, 413))
print(Solution().fractionToDecimal(87, 22))
print(Solution().fractionToDecimal(826, 393))