package leetcode

class LeetCode2579 {
    fun coloredCells(n: Int): Long {
        if (n == 1) {
            return 1
        }

        return coloredCells(n - 1) + (n - 1) * 4
    }
}