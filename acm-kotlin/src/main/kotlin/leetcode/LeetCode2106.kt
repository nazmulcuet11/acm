package leetcode

import kotlin.math.max

class LeetCode2106 {
    fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
        val n = fruits.size
        val psum = IntArray(n) { 0 }
        for (i in fruits.indices) {
            psum[i] = fruits[i][1]
            if (i > 0) {
                psum[i] += psum[i - 1]
            }
        }

        // find the maximum index `i` after start where the fruits[i][0] <= pos
        fun findMaxIndex(pos: Int, start: Int): Int {
            var l = start
            var r = n - 1
            while (l < r) {
                val m = (l + r + 1) / 2
                if (fruits[m][0] <= pos) {
                    l = m
                } else {
                    r = m - 1
                }
            }
            return l
        }

        var ans = 0

        fun updateAns(i: Int, j: Int) {
            var sum = psum[j]
            if (i > 0) {
                sum -= psum[i - 1]
            }

            ans = max(ans, sum)
        }

        var i = 0

        while (i < n && fruits[i][0] < startPos - k) {
            i++
        }

        while (i < n && fruits[i][0] <= startPos + k) {
            val leftDist = max(0, startPos - fruits[i][0])

            // left first and then right
            var j = findMaxIndex(startPos + k - 2 * leftDist, i)
            updateAns(i, j)

            // right first and then left
            j = findMaxIndex(startPos + (k - leftDist) / 2, i)
            updateAns(i, j)

            i++
        }

        return ans
    }
}