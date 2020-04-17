factorials = [1]
def calc_factorials(n):
    global factorials
    if n < len(factorials):
        return
    l = len(factorials)
    for i in range(l, n+1):
        factorials.append(factorials[-1] * i) 
    

def kth_permutation(n , k):
    ans  = []
    available = [i for i in range(1, n+1)]
    calc_factorials(n)
    while n:
        t = factorials[n-1]
        for val in available:
            if t < k:
                k -= t
            else:
                ans.append(str(val))
                available.remove(val)
                break
        n -= 1
    return ''.join(ans)

class Solution:
    # @param A : integer
    # @param B : integer
    # @return a strings
    def getPermutation(self, A, B):
        return kth_permutation(A, B)

print(kth_permutation(3, 1))
print(kth_permutation(3, 2))
print(kth_permutation(3, 3))
print(kth_permutation(3, 4))
print(kth_permutation(3, 5))
print(kth_permutation(3, 6))

