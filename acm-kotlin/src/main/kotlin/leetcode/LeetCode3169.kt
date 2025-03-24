package leetcode

import kotlin.math.max

class LeetCode3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy { it[0] }

        var i = 0
        var meetingDays = 0
        while (i < meetings.size) {
            val start = meetings[i][0]
            var end = meetings[i][1]
            while (i < meetings.size && meetings[i][0] <= end) {
                end = max(end, meetings[i][1])
                i++
            }

            meetingDays += end - start + 1
        }

        return days - meetingDays
    }
}