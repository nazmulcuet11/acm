class Solution:
    def maxSubArray(self, A):
        curr_sum, max_sum = 0, A[0] if len(A) > 0 else 0
        for num in A:
            max_sum = max(curr_sum + num, max_sum)
            curr_sum = max(curr_sum + num, 0)
        
        return max_sum

if __name__ == "__main__":
    print(Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(Solution().maxSubArray([-500]))
