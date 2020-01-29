import resource, sys
resource.setrlimit(resource.RLIMIT_STACK, (2**29,-1))
sys.setrecursionlimit(10**6)
 
def dfs(x, A):
    if A[x] < 0:
        return A[x]
 
    t = A[x]
    A[x] = -A[x]
    next = 0 if t == len(A) else t
    A[x] = dfs(next, A)
    return -t
 
class Solution:
    # @param A : list of integers
    # Modify the array A which is passed by reference. 
    # You do not need to return anything in this case. 
    def arrange(self, A):
        N = len(A)
        for i in range(N): 
            if A[i] == 0:
                A[i] = N
            
    
        for i in range(N):
            if A[i] > 0:
                dfs(i, A)
    
        for i in range(N): 
            A[i] = -A[i]
            if A[i] == N:
                A[i] = 0
 
        return A