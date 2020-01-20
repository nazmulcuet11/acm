def getChar(number):
    return chr(ord('A') + number)

class Solution:
    # @param A : string
    # @return an integer
    def convertToTitle(self, number):
        charachters = []
        while number > 0:
            r = (number + 25) % 26
            number = int((number - 1) / 26)
            charachters.append(getChar(r))
        ans = "".join(reversed(charachters))
        return ans

print(Solution().convertToTitle(1405))
print(Solution().convertToTitle(54))
print(Solution().convertToTitle(1))
print(Solution().convertToTitle(2))
print(Solution().convertToTitle(26))
print(Solution().convertToTitle(27))
print(Solution().convertToTitle(28))
print(Solution().convertToTitle(3))
