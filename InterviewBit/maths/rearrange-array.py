import resource
import sys

# resource.setrlimit(resource.RLIMIT_STACK, (2**29,-1))
sys.setrecursionlimit(10**6)


def dfs(i, A):
    N = len(A)
    if A[i] >= N:
        return A[i]

    t = A[i] = A[i] + N
    A[i] = dfs(A[i] % N, A)
    return t


class Solution:
    # @param A : list of integers
    # Modify the array A which is passed by reference.
    # You do not need to return anything in this case.
    def arrange(self, A):
        N = len(A)
        for i in range(N):
            if A[i] < N:
                dfs(i, A)

        for i in range(N):
            A[i] = A[i] % N

        return A


print(Solution().arrange([4, 0, 2, 1, 3]))
