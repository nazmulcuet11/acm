package leetcode

import kotlin.math.min

class LeetCode440 {
    private fun countNodes(curr: Long, next: Long, n: Long): Long {
        if (curr > n) {
            return 0
        }

        return (min(next, n + 1) - curr) + countNodes(curr * 10, next * 10, n)
    }

    private fun solve(c: Int, n: Int, k: Int): Int {
        if (k == 1) {
            return c
        }

        val count = countNodes(c.toLong(), c + 1L, n.toLong()).toInt()
        return if (count >= k) {
            solve(c * 10, n, k - 1)
        } else {
            solve(c + 1, n, k - count)
        }
    }

    fun findKthNumber(n: Int, k: Int): Int {
        return solve(1, n, k)
    }
}