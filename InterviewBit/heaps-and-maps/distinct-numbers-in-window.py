class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of integers
    def dNums(self, A, B):
        if B > len(A):
            return []

        hash = {}
        ans = []
        i = 0
        while i < B:
            hash[A[i]] = hash.get(A[i], 0) + 1
            i += 1
        ans.append(len(hash.keys()))
        while i < len(A):
            val_to_remove = A[i - B]
            val_to_add = A[i]

            hash[val_to_remove] -= 1
            if hash[val_to_remove] == 0:
                del hash[val_to_remove]

            hash[val_to_add] = hash.get(val_to_add, 0) + 1

            ans.append(len(hash.keys()))

            i += 1

        return ans


print(Solution().dNums([1, 2, 1, 3, 4, 3], 3))
print(Solution().dNums([1, 1, 2, 2], 1))
