class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @param C : list of integers
    # @return a list of integers
    def solve(self, A, B, C):
        a_set = set(A)
        b_set = set(B)
        c_set = set(C)

        ans = set()
        for v in A:
            if v in b_set or v in c_set:
                ans.add(v)

        for v in B:
            if v in a_set or v in c_set:
                ans.add(v)

        for v in C:
            if v in a_set or v in b_set:
                ans.add(v)

        return list(ans)
