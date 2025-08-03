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
        // println(psum.toList())

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

            if (sum > ans) {
                println("i: $i, j: $j, sum: $sum")
            }

            ans = max(ans, sum)
        }

        for (i in fruits.indices) {
            if (fruits[i][0] > startPos) {
                if (fruits[i][0] - startPos <= k) {
                    // traverse only right
                    val j = findMaxIndex(startPos + k, i)
                    updateAns(i, j)
                }
                break
            }

            val leftDist = startPos - fruits[i][0]
            if (leftDist <= k) {
                // traverse only left
                val j = findMaxIndex(startPos, i)
                updateAns(i, j)
            }

            if (leftDist * 2 <= k) {
                // traverse left first and then right
                val j = findMaxIndex(startPos + (k - 2 * leftDist), i)
                updateAns(i, j)
            }

            if (leftDist <= k) {
                // traverse right first and then left
                val j = findMaxIndex(startPos + (k - leftDist) / 2, i)
                updateAns(i, j)
            }
        }

        return ans
    }
}