package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3439 {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        data class Meeting(val start: Int, val end: Int)

        val meetings = mutableListOf<Meeting>()
        startTime.zip(endTime).forEach {
            meetings.add(Meeting(it.first, it.second))
        }

        meetings.sortBy { it.start }

        val gaps = mutableListOf<Int>()
        var lastEnd = 0
        for (meeting in meetings) {
            val gap = meeting.start - lastEnd
            if (gap > 0) {
                gaps.add(gap)
            }
            lastEnd = meeting.end
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