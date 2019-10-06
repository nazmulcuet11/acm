class Solution:
    # @param A : list of integers
    # @return a list of integers
    def plusOne(self, A):
        ans = []
        carry = 0
        addend = 1
        for i in range(len(A)-1, -1, -1):
            sum = A[i] + carry + addend
            ans.append(int(sum % 10))
            carry = int(sum / 10)
            addend = 0

        if carry > 0:
            ans.append(carry)

        while len(ans) > 0 and ans[-1] == 0:
            ans.pop(-1)

        return list(reversed(ans))


# ans = Solution().plusOne([1, 2, 3])
ans = Solution().plusOne([ 9, 9, 9, 9, 9 ])
print(ans)