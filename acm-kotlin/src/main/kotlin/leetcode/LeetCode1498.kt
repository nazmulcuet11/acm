package leetcode

class LeetCode1498 {
    fun numSubseq(nums: IntArray, target: Int): Int {
        val mod = (1e9 + 7).toLong()

        nums.sort()

        fun modPow(p: Int): Long {
            if (p == 0) {
                return 1
            }

            val halfResult = modPow(p / 2)
            var fullResult = (halfResult * halfResult) % mod
            if (p % 2 == 1) {
               fullResult = (fullResult * 2) % mod
            }
            return fullResult
        }

        var left = 0
        var right = nums.size - 1
        var ans = 0L
        while (left < nums.size) {
            while (left <= right && nums[left] + nums[right] > target) {
                right--
            }

            if (left <= right) {
                ans = (ans + modPow(right - left)) % mod
            }
            left++
        }
        return ans.toInt()
    }
}