package leetcode

import kotlin.math.max

class LeetCode3394 {
    private fun merge(intervals: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val sortedIntervals = intervals.sortedBy { it.first }

        val merged = mutableListOf<Pair<Int, Int>>()
        var i = 0
        while (i < sortedIntervals.size) {
            val start = sortedIntervals[i].first
            var end = sortedIntervals[i].second
            while (i < sortedIntervals.size && sortedIntervals[i].first < end) {
                end = max(end, sortedIntervals[i].second)
                i++
            }
            merged.add(Pair(start, end))
        }

        return merged
    }

    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        val vertical = rectangles.map { Pair(it[0], it[2]) }
        val horizontal = rectangles.map { Pair(it[1], it[3]) }
        val mergedVertical = merge(vertical)
        val mergedHorizontal = merge(horizontal)
        return mergedVertical.size >= 3 || mergedHorizontal.size >= 3
    }
}