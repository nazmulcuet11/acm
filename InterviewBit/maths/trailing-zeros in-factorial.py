def trailingZerosInFact(number):
    count = 0
    while number > 0:
        count += int(number / 5)
        number = int(number / 5)
    return count

class Solution:
    # @param A : integer
    # @return an integer
    def trailingZeroes(self, A):
        return trailingZerosInFact(A)

print(trailingZerosInFact(7795))