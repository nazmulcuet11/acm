package leetcode

class LeetCode1267 {
    fun countServers(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var total = 0
        val rowCount = IntArray(m) { 0 }
        val colCount = IntArray(n) { 0 }
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == 1) {
                    rowCount[i]++
                    colCount[j]++
                    total++
                }
            }
        }
        var connected = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    connected++
                }
            }
        }
        return connected
    }
}