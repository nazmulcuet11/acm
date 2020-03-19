def divide(number, divisor):
    i, temp = 0, 0
    while i < len(number) and temp < divisor:
        temp = temp * 10 + int(number[i])
        i += 1

    ans = []
    while i < len(number):
        ans.append(str(temp // divisor))
        temp = (temp % divisor) * 10 + int(number[i])
        i += 1
    ans.append(str(temp // divisor))
    if len(ans) == 0:
        return "0"
    return ''.join(ans)

class Solution:
    # @param A : string
    # @return an integer
    def power(self, A):
        if A == "1":
            return 0
        if A == "0":
            return 1

        while int(A[-1]) % 2 == 0 and A != "0":
            A = divide(A, 2)
        return 1 if A == "1" else 0

print(Solution().power("20"))