def isPalindrome(str):
    i, j = 0, len(str)-1
    while i < j:
        if str[i] != str[j]:
            return False
        i += 1
        j -= 1
    return True

def toString(number):
    numberStr = ""
    while number > 0:
        r = number % 10
        numberStr += chr(int(ord('0') + r))
        number = int(number/10)
    return numberStr

class Solution:
    # @param A : integer
    # @return an integer
    def isPalindrome(self, A):
        if A < 0:
            return False
        return isPalindrome(str(A))

print(Solution().isPalindrome(12121))
print(Solution().isPalindrome(123))

