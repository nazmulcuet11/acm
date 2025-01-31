package leetcode

import kotlin.math.max

class LeetCode827 {
    fun largestIsland(grid: Array<IntArray>): Int {
        val n = grid.size
        var groupNumber = 2

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        fun dfs(i: Int, j: Int): Int {
            if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
                return 0
            }

            grid[i][j] = groupNumber
            var ans = 1
            for (k in 0..<4) {
                ans += dfs(i + dx[k], j + dy[k])
            }
            return ans
        }

        val groupSize = mutableMapOf<Int, Int>()
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (grid[i][j] == 1) {
                    val size = dfs(i, j)
                    groupSize[groupNumber] = size
                    groupNumber++
                }
            }
        }

        var ans = 0
        for (gs in groupSize.values) {
            ans = max(ans, gs)
        }

        for (i in 0..<n) {
            for (j in 0..<n) {
                if (grid[i][j] == 0) {
                    val groups = mutableSetOf<Int>()
                    for (k in 0..<4) {
                        val ni = i + dx[k]
                        val nj = j + dy[k]
                        if (ni in 0..<n && nj in 0..<n) {
                            groups.add(grid[ni][nj])
                        }
                    }

                    var sum = 1
                    for (group in groups) {
                        groupSize[group]?.let {
                            sum += it
                        }
                    }
                    ans = max(ans, sum)
                }
            }
        }
        return ans
    }
}