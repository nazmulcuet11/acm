class Solution:
    # @param A : string
    # @return an integer
    def solve(self, A):
        hash = {}
        for c in A:
            v = hash.get(c, 0)
            hash[c] = v + 1

        odd_count = 0
        for k in hash:
            if hash[k] % 2 != 0:
                odd_count += 1

        if odd_count > 1:
            return 0
        return 1
