package leetcode.weekly429

import kotlin.math.ceil

class Question1 {
    fun minimumOperations(nums: IntArray): Int {
        val values = mutableSetOf<Int>()
        for (i in nums.size - 1 downTo 0) {
            if (values.contains(nums[i])) {
                return ceil((i + 1).toDouble() / 3.0).toInt()
            }
            values.add(nums[i])
        }
        return 0
    }
}