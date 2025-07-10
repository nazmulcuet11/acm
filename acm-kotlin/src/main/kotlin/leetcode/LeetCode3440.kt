package leetcode

import kotlin.math.max

class LeetCode3440 {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val gaps = mutableListOf<Int>()
        var lastEnd = 0
        for (i in startTime.indices) {
            val gap = startTime[i] - lastEnd
            gaps.add(gap)
            lastEnd = endTime[i]
        }

        gaps.add(eventTime - lastEnd)

        val maxGapOnLeft = MutableList(gaps.size) { 0 }
        maxGapOnLeft[0] = gaps[0]
        for (i in 1..<gaps.size) {
            maxGapOnLeft[i] = max(gaps[i], maxGapOnLeft[i - 1])
        }

        val maxGapOnRight = MutableList(gaps.size) { 0 }
        maxGapOnRight[gaps.size - 1] = gaps[gaps.size - 1]
        for (i in gaps.size - 2 downTo 0) {
            maxGapOnRight[i] = max(gaps[i], maxGapOnRight[i + 1])
        }

        fun duration(i: Int) = endTime[i] - startTime[i]
        fun canMoveInLeft(i: Int) = i - 1 >= 0 && maxGapOnLeft[i - 1] >= duration(i)
        fun canMoveInRight(i: Int) = i + 2 < gaps.size && maxGapOnRight[i + 2] >= duration(i)

        var ans = 0
        for (i in startTime.indices) {
            // move ith meeting to between some other meeting
            if (canMoveInLeft(i) || canMoveInRight(i)) {
                ans = max(ans, gaps[i] + duration(i) + gaps[i + 1])
            }
            // push ith meeting to the left or right
            ans = max(ans, gaps[i] + gaps[i + 1])
        }

        return ans
    }
}