package leetcode.weekly430

class Question1 {
    private fun countForColumn(c: Int, grid: Array<IntArray>): Int {
        var ans = 0
        for (r in 1..<grid.size) {
            if (grid[r][c] <= grid[r - 1][c]) {
                ans += grid[r - 1][c] + 1 - grid[r][c]
                grid[r][c] = grid[r - 1][c] + 1
            }
        }
        return ans
    }

    fun minimumOperations(grid: Array<IntArray>): Int {
        var ans = 0
        for (c in grid.first().indices) {
            ans += countForColumn(c, grid)
        }
        return ans
    }
}