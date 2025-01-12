package leetcode.weekly432

class Question1 {
    fun zigzagTraversal(grid: Array<IntArray>): List<Int> {
        val n = grid.size
        val m = grid[0].size
        var take = true
        var forward = true
        var i = 0
        var j = 0
        val ans = mutableListOf<Int>()
        while (i < n) {
            if (take) {
                ans.add(grid[i][j])
            }
            take = !take

            if (forward) {
                j++
                if (j == m) {
                    j = m - 1
                    i++
                    forward = false
                }

            } else {
                j--
                if (j == -1) {
                    j = 0
                    i++
                    forward = true
                }
            }
        }
        return ans
    }
}