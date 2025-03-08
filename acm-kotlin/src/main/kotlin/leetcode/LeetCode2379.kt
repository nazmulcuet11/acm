package leetcode

import kotlin.math.min

class LeetCode2379 {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var whiteCount = 0
        for (i in 0..<k) {
            if (blocks[i] == 'W') {
                whiteCount++
            }
        }

        var ans = whiteCount
        for (i in k..<blocks.length) {
            if (blocks[i] == 'W') {
                whiteCount++
            }
            if (blocks[i - k] == 'W') {
                whiteCount--
            }
            ans = min(ans, whiteCount)
        }
        return ans
    }
}