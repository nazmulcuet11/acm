package leetcode

class LeetCode2616 {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        val n = nums.size
        nums.sort()
        fun countNumberOfPairsWithDiffLessOrEqualTo(guess: Int): Int {
            var count = 0
            var i = 0
            while (i < n - 1) {
                if (nums[i + 1] - nums[i] <= guess) {
                    count++
                    i += 2
                } else {
                    i++
                }
            }
            return count
        }

        var low = 0
        var high = nums[n - 1] - nums[0]
        while (low < high) {
            val mid = low + (high - low) / 2
            val count = countNumberOfPairsWithDiffLessOrEqualTo(mid)
            if (count >= p) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}

