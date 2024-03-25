package leetcode

import kotlin.math.min

class LeetCode45 {
    companion object {
        const val MAX_VALUE = 9999999
    }

    fun jump(nums: IntArray): Int {
        return jump(nums, 0, mutableMapOf())
    }

    private fun jump(
        nums: IntArray,
        i: Int,
        cache: MutableMap<Int, Int>
    ): Int {
        if (i >= nums.count() - 1) {
            return 0
        }

        cache[i]?.let { return it }

        var ans = MAX_VALUE
        for (j in 1..nums[i]) {
            ans = min(ans, jump(nums, i + j, cache))
        }

        cache[i] = ans + 1
        return ans + 1
    }
}