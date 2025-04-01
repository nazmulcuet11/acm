package leetcode

import kotlin.math.max

class LeetCode2140 {
    fun mostPoints(questions: Array<IntArray>): Long {
        val cache = LongArray(questions.size) { -1 }
        fun solve(i: Int): Long {
            if (i >= questions.size) {
                return 0
            }

            if (cache[i] != -1L) {
                return cache[i]
            }

            val a = solve(i + questions[i][1] + 1) + questions[i][0]
            val b = solve(i + 1)
            cache[i] = max(a, b)
            return cache[i]
        }
        return solve(0)
    }
}