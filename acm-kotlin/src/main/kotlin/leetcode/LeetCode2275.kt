package leetcode

import kotlin.math.max

class LeetCode2275 {
    fun largestCombination(candidates: IntArray): Int {
        var maxBitCount = 0
        for (i in 0..<64) {
            var bitCount = 0
            for (c in candidates) {
                if (c and (1 shl i) > 0) {
                    bitCount++
                }
            }
            maxBitCount = max(maxBitCount, bitCount)
        }
        return maxBitCount
    }
}