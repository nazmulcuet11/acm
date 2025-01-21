package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode2017 {
    fun gridGame(grid: Array<IntArray>): Long {
        val n = grid[0].size
        val prefixSum = Array(2) { LongArray(n) { 0 } }
        prefixSum[0][0] = grid[0][0].toLong()
        prefixSum[1][0] = grid[1][0].toLong()
        for (i in 1..<n) {
            prefixSum[0][i] = prefixSum[0][i - 1] + grid[0][i]
            prefixSum[1][i] = prefixSum[1][i - 1] + grid[1][i]
        }

        var ans = Long.MAX_VALUE
        // assume robot1 turns at index i, how much points then robot2 can collect?
        for (i in 0..<n) {
            val top = prefixSum[0][n - 1] - prefixSum[0][i]
            val bottom = if (i > 0) prefixSum[1][i - 1] else 0
            ans = min(ans, max(top, bottom))
        }
        return ans
    }
}