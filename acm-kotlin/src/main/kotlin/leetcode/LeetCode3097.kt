package leetcode

import kotlin.math.min

class LeetCode3097 {
    private val bitCounts = IntArray(32) { 0 }

    private fun add(n: Int) {
        for (i in 0..<32) {
            if (n and (1 shl i) > 0) {
                bitCounts[i]++
            }
        }
    }

    private fun remove(n: Int) {
        for (i in 0..<32) {
            if (n and (1 shl i) > 0) {
                bitCounts[i]--
            }
        }
    }

    private fun value(): Int {
        var n = 0
        for (i in 0..<32) {
            if (bitCounts[i] > 0) {
                n = n or (1 shl i)
            }
        }
        return n
    }

    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var minLength = Integer.MAX_VALUE
        var i = 0
        var j = 0
        while (j < nums.size) {
            add(nums[j])
            j++
            while (i < j && value() >= k) {
                minLength = min(minLength, j - i)
                remove(nums[i])
                i++
            }
        }
        return if (minLength == Integer.MAX_VALUE) -1 else minLength
    }
}