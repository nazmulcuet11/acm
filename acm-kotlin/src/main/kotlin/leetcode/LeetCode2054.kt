package leetcode

import kotlin.math.max

class LeetCode2054 {
    private fun isOverlapping(a: IntArray, b: IntArray): Boolean {
        return  !(a[1] < b[0] || b[1] < a[0])
    }

    private fun nextNonOverlappingIndex(events: Array<IntArray>, i: Int): Int? {
        var l = i + 1
        var r = events.size - 1
        while (l < r) {
            val m = l + (r - l) / 2
            if (isOverlapping(events[i], events[m])) {
                l = m + 1
            } else {
                r = m
            }
        }
        return if (l < events.size && !isOverlapping(events[i], events[l])) {
            l
        } else {
            null
        }
    }

    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }

        val maxValues = mutableListOf<Int>()
        for (i in events.indices.reversed()) {
            if (maxValues.isEmpty()) {
                maxValues.add(events[i][2])
            } else {
                maxValues.add(max(events[i][2], maxValues.last()))
            }
        }
        maxValues.reverse()

        var ans = 0
        for (i in events.indices) {
            ans = max(ans, events[i][2])
            nextNonOverlappingIndex(events, i)?.let {
                ans = max(ans, events[i][2] + maxValues[it])
            }
        }
        return ans
    }
}
