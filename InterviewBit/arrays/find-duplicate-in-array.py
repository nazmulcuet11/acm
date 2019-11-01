class Solution:
    # @param A : tuple of integers
    # @return an integer
    def repeatedNumber(self, A):
        # counter = [0 for _ in range(len(A)+5)]
        # for e in A:
        #     counter[e] += 1
        #     if counter[e] > 1:
        #         return e

        # return -1
        slow, fast = A[0], A[A[0]]
        while slow != fast:
            slow = A[slow]
            fast = A[A[fast]]
        
        fast = 0
        while fast != slow:
            fast = A[fast]
            slow = A[slow]

        return slow

# print(Solution().repeatedNumber([3, 4, 1, 4, 1]))
print(Solution().repeatedNumber([3, 9, 8, 4, 7, 6, 5, 7, 2, 1]))