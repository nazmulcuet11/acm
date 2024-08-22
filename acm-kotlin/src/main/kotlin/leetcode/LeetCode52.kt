package leetcode

import kotlin.math.abs

class LeetCode52 {
    data class Queen(
        val x: Int,
        val y: Int
    )

    private var n: Int = 0
    private var queens = mutableListOf<Queen>()

    private fun canAttack(a: Queen, b: Queen): Boolean {
        return a.x == b.x || a.y == b.y || abs(a.x - b.x) == abs(a.y - b.y)
    }

    private fun canPlace(newQueen: Queen): Boolean {
        for (queen in queens) {
            if (canAttack(queen, newQueen)) {
                return false
            }
        }
        return true
    }

    private fun solve(row: Int): Int {
        if (queens.size == n) {
            return 1
        }

        var ans = 0
        for (col in 0..<n) {
            val newQueen = Queen(row, col)
            if (canPlace(newQueen)) {
                queens.add(newQueen)
                ans += solve(row + 1)
                queens.removeLast()
            }
        }
        return ans
    }

    fun totalNQueens(n: Int): Int {
        this.n = n
        this.queens = mutableListOf()
        return solve(0)
    }
}