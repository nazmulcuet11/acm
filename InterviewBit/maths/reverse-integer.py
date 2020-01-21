def removeLeadingZeros(s):
    i = 0
    while i < len(s) and s[i] == '0':
        i += 1
    return s[i:len(s)]

def toString(number):
    numberStr = ""
    while number > 0:
        r = number % 10
        numberStr += chr(int(ord('0') + r))
        number = int(number/10)
    return numberStr

def toNumber(numberStr):
    number = 0
    for c in numberStr:
        number = number * 10 + ord(c) - ord('0')
    return number


def isChecksumEqueal(a, b):
    s1, s2 = 0, 0
    r1 = toString(a)
    r2 = toString(b)
    for c in r1:
        s1 += ord(c) - ord('0')
    for c in r2:
        s2 += ord(c) - ord('0')
    return s1 == s2

class Solution:
    # @param A : integer
    # @return an integer
    def reverse(self, A):
        sign = -1 if A < 0 else 1
        A = sign * A
        X = toNumber(toString(A))
        INT_MAX = 2147483647
        if X > INT_MAX:
            return 0
        return sign * X



print(toString(1230000))
print(toNumber('000123'))