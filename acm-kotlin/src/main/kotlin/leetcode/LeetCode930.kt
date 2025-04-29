package leetcode

class LeetCode930 {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        // solve(target: Int) returns number of sub arrays with sum <= target
        fun solve(target: Int): Int {
            var i = 0
            var j = 0
            var sum = 0
            var ans = 0
            while (j < nums.size) {
                sum += nums[j]

                while (i <= j && sum > target) {
                    sum -= nums[i]
                    i++
                }

                ans += j - i + 1
                j++
            }
            return ans
        }

        return solve(goal) - solve(goal - 1)
    }
}