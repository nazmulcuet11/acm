package leetcode

class LeetCode2965 {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size
        val count = IntArray(n * n +  1) { 0 }
        for (row in grid) {
            for (x in row) {
                count[x]++
            }
        }

        var repeating = 0
        var missing = 0
        for (i in 1..n * n) {
            if (count[i] == 0) {
                missing = i
            } else if (count[i] == 2) {
                repeating = i
            }
        }

        return intArrayOf(repeating, missing)
    }
}