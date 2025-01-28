package leetcode

import kotlin.math.max

class LeetCode2658 {
    fun findMaxFish(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size

        val dx = intArrayOf(0, -1, 0, 1)
        val dy = intArrayOf(-1, 0, 1, 0)

        fun fish(i: Int, j: Int): Int {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
                return 0
            }

            var ans = grid[i][j]
            grid[i][j] = 0
            for (k in 0..<4) {
                ans += fish(i + dx[k], j + dy[k])
            }
            return ans
        }

        var ans = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                ans = max(ans, fish(i, j))
            }
        }
        return ans
    }
}