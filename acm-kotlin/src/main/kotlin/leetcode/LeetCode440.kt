package leetcode

import kotlin.math.min

class LeetCode440 {
    fun findKthNumber(n: Int, k: Int): Int {
        fun countNodes(curr: Long, next: Long): Long {
            if (curr > n) {
                return 0
            }

            return (min(next, n + 1L) - curr) + countNodes(curr * 10, next * 10)
        }

        fun solve(c: Int, k: Int): Int {
            if (k == 1) {
                return c
            }

            val count = countNodes(c.toLong(), c + 1L).toInt()
            return if (count >= k) {
                solve(c * 10, k - 1)
            } else {
                solve(c + 1, k - count)
            }
        }

        return solve(1, k)
    }
}