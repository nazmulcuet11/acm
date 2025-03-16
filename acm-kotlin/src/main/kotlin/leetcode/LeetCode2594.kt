package leetcode

import kotlin.math.sqrt

class LeetCode2594 {
    private fun verify(ranks: IntArray, cars: Int, time: Long): Boolean {
        var total = 0L
        for (r in ranks) {
            val c = sqrt((time / r).toDouble()).toInt()
            total += c
        }
        return total >= cars
    }

    fun repairCars(ranks: IntArray, cars: Int): Long {
        var l = 1L
        var r = ranks.max().toLong() * cars * cars
        while (l < r) {
            val m = (l + r) / 2
            if (verify(ranks, cars, m)) {
                r = m
            } else {
                l = m + 1
            }
        }
        return l
    }
}