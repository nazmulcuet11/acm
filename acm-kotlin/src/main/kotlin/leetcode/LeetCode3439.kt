package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3439 {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val gaps = mutableListOf<Int>()
        var lastEnd = 0
        for (i in startTime.indices) {
            val gap = startTime[i] - lastEnd
            gaps.add(gap)
            lastEnd = endTime[i]
        }

        if (lastEnd < eventTime) {
            gaps.add(eventTime - lastEnd)
        }

        var sum = 0
        for (i in 0..<min(k + 1, gaps.size)) {
            sum += gaps[i]
        }

        var ans = sum
        for (i in k + 1..<gaps.size) {
            sum += gaps[i]
            sum -= gaps[i - k - 1]
            ans = max(ans, sum)
        }

        return ans
    }
}