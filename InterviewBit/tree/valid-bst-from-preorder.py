# MAX_VAL = 1e6 + 1
# MIN_VAL = 0


# class Solution:
#     def is_valid(self, root_idx, end_idx, next_large_index, A, mn_allowed_val, mx_allowed_val):
#         if root_idx >= end_idx:
#             return True

#         root_val = A[root_idx]
#         if root_val < mn_allowed_val or root_val > mx_allowed_val:
#             return False

#         left_root_idx = root_idx + 1
#         right_root_idx = next_large_index[root_idx]
#         left_mx_allowed_val = min(mx_allowed_val, root_val)
#         right_mn_allowed_val = max(mn_allowed_val, root_val + 1)

#         if right_root_idx < end_idx:
#             # has right sub tree
#             t1 = self.is_valid(left_root_idx, right_root_idx - 1,
#                                next_large_index, A, mn_allowed_val, left_mx_allowed_val)
#             t2 = self.is_valid(right_root_idx, end_idx,
#                                next_large_index, A, right_mn_allowed_val, mx_allowed_val)
#             return t1 and t2
#         else:
#             # only left subtree
#             return self.is_valid(left_root_idx, end_idx, next_large_index, A, mn_allowed_val, left_mx_allowed_val)

#     def solve(self, A):
#         next_large_index = [len(A)] * len(A)
#         stk = []
#         for (idx, val) in enumerate(A):
#             while len(stk) > 0 and stk[-1][0] < val:
#                 next_large_index[stk[-1][1]] = idx
#                 stk.pop()
#             stk.append((val, idx))
#         ret_val = self.is_valid(
#             0, len(A)-1, next_large_index, A, MIN_VAL, MAX_VAL)
#         return 1 if ret_val else 0

class Solution:
    def solve(self, A):
        mn_allowed_val = 0
        stk = []
        for val in A:
            if val < mn_allowed_val:
                return 0
            # Move up before going to right side of the tree
            while len(stk) > 0 and stk[-1] < val:
                # if we go the right of stk[-1] we can not accept value <= stk[-1]
                mn_allowed_val = stk[-1] + 1
                stk.pop()
            stk.append(val)
        return 1


print(Solution().solve([4, 2, 1, 3, 6, 5, 7]))
print(Solution().solve([7, 7, 10, 10, 9, 5, 2, 8]))
print(Solution().solve([315, 279, 263, 205, 187, 184, 70, 68, 141, 100, 176, 185, 193, 309, 839, 749, 491, 384, 364, 416, 392, 386, 418, 417, 457, 433,
                        655, 645, 596, 584, 524, 630, 748, 667, 658, 692, 735, 732, 805, 787, 773, 763, 763, 796, 897, 896, 859, 863, 886, 960, 948, 943, 969, 996, 989]))
