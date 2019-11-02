# Solution One

# import bisect

# def find_lt(a, x):
#     'Find rightmost value less than x'
#     i = bisect.bisect_left(a, x)
#     if i:
#         return a[i-1]
#     return 0

# def find_gt(a, x):
#     'Find leftmost value greater than x'
#     i = bisect.bisect_right(a, x)
#     if i != len(a):
#         return a[i]
#     return 0

# class Solution:
#     # @param A : list of integers
#     # @return an integer
#     def maxSpecialProduct(self, A):
#         MOD = 1000000007

#         A = list(map(lambda x: x[1], sorted([(A[i], i) for i in range(len(A))])))
#         # print(A)
#         mx, a = 0, []
#         for i in range(len(A)-1, -1, -1):
#             x = find_lt(a, A[i])
#             y = find_gt(a, A[i])
#             mx = max(mx, x * y)
#             bisect.insort_right(a, A[i])
#         return mx % MOD


# Solution Two
class Solution:
    # @param A : list of integers
    # @return an integer
    def maxSpecialProduct(self, A):
        MOD = 1000000007

        A = [(A[i], i) for i in range(len(A))]
        left = [0]*len(A)
        stk = []
        for i in range(len(A)):
            while len(stk) > 0 and stk[-1][0] <= A[i][0]:
                stk.pop()
            left[i] = stk[-1][1] if len(stk) > 0 else 0
            # left[i] = left[i] % MOD
            stk.append(A[i])

        stk = []
        ans = 0
        for i in range(len(A)-1, -1, -1):
            while len(stk) > 0 and stk[-1][0] <= A[i][0]:
                stk.pop()
            t = stk[-1][1] if len(stk) > 0 else 0
            # t = t % MOD
            t = (t * left[i])
            ans = max(ans, t)
            stk.append(A[i])
        # print(left)
        return ans % MOD

print(Solution().maxSpecialProduct([5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9]))
print(Solution().maxSpecialProduct([6, 7, 9, 5, 5, 8]))
print(Solution().maxSpecialProduct([6, 5, 4, 9, 9, 6, 5, 4, 5, 9, 9]))