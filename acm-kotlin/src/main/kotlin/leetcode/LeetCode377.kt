package leetcode

class LeetCode377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val cache = IntArray(target + 1) { -1 }
        fun solve(sum: Int): Int {
            if (sum == 0) {
                return 1
            }

            if (sum < 0) {
                return 0
            }

            if (cache[sum] != -1) {
                return cache[sum]
            }

            var ans = 0
            for (n in nums) {
                ans += solve(sum - n)
            }
            cache[sum] = ans
            return ans
        }

        return solve(target)
    }
}