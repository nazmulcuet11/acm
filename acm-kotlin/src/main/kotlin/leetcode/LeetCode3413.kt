package leetcode

import kotlin.math.max

class LeetCode3413 {
    data class Segment(val start: Int, val end: Int, val value: Int) {
        val total: Long
            get() = (end - start + 1) * value.toLong()
    }

    fun maximumCoins(coins: Array<IntArray>, k: Int): Long {
        val segments = coins.map { Segment(it[0], it[1], it[2]) }.sortedBy { it.start }
        var ans = 0L
        var i = 0
        var j = 0
        var sum = 0L
        while (i < segments.size) {
            val windowStart = segments[i].start
            val windowEnd = windowStart + k - 1
            while (j < segments.size && windowEnd >= segments[j].end) {
                sum += segments[j].total
                ans = max(ans, sum)
                j++
            }

            if (j < segments.size && windowEnd >= segments[j].start) {
                val diff = windowEnd - segments[j].start + 1
                val partial = diff * segments[j].value
                ans = max(ans, sum + partial)
            }

            sum -= segments[i].total
            i++
        }

        sum = 0
        i = segments.size - 1
        j = segments.size - 1
        while (j >= 0) {
            val windowEnd = segments[j].end
            val windowStart = windowEnd - k + 1

            while (i >= 0 && windowStart <= segments[i].start) {
                sum += segments[i].total
                ans = max(ans, sum)
                i--
            }

            if (i >= 0 && windowStart <= segments[i].end) {
                val diff = segments[i].end - windowStart + 1
                val partial = diff * segments[i].value
                ans = max(ans, sum + partial)
            }

            sum -= segments[j].total
            j--
        }

        return ans
    }
}