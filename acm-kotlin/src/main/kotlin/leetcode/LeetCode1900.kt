package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode1900 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {

        fun Int.isBitSet(i: Int) = (this and (1 shl i)) > 0
        fun Int.clearBit(i: Int) = this and (1 shl i).inv()

        val infinity = 100

        var maxRound = -infinity
        var minRound = infinity

        fun solve(mask: Int, round: Int, i: Int, j: Int) {
            if (i >= j) {
                solve(mask, round + 1, 0, n - 1)
            } else if (!mask.isBitSet(i)) {
                solve(mask, round, i + 1, j)
            } else if (!mask.isBitSet(j)) {
                solve(mask, round, i, j - 1)
            } else if (i == firstPlayer - 1 && j == secondPlayer - 1) {
                maxRound = max(maxRound, round)
                minRound = min(minRound, round)
            } else if (i == firstPlayer - 1 || i == secondPlayer - 1) {
                solve(mask.clearBit(j), round, i + 1, j - 1)
            } else if (j == firstPlayer - 1 || j == secondPlayer - 1) {
                solve(mask.clearBit(i), round, i + 1, j - 1)
            } else {
                solve(mask.clearBit(i), round, i + 1, j - 1)
                solve(mask.clearBit(j), round, i + 1, j - 1)
            }
        }

        solve((1 shl n) - 1, 1, 0, n - 1)

        return intArrayOf(minRound, maxRound)
    }
}