package leetcode

import kotlin.math.max

class LeetCode763 {
    fun partitionLabels(s: String): List<Int> {
        val firstIndex = mutableMapOf<Char, Int>()
        val lastIndex = mutableMapOf<Char, Int>()
        for ((i, c) in s.withIndex()) {
            if (firstIndex[c] == null) {
                firstIndex[c] = i
                lastIndex[c] = i
            } else {
                lastIndex[c] = i
            }
        }

        val intervals = mutableListOf<Pair<Int, Int>>()
        for (c in 'a'..'z') {
            val fi = firstIndex.getOrDefault(c, -1)
            val li = lastIndex.getOrDefault(c, -1)
            if (fi != -1) {
                intervals.add(Pair(fi, li))
            }
        }

        intervals.sortBy { it.first }

        val mergedIntervals = mutableListOf<Pair<Int, Int>>()
        for (interval in intervals) {
            if (mergedIntervals.isEmpty() || interval.first > mergedIntervals.last().second) {
                mergedIntervals.add(interval)
            } else {
                val lastInterval = mergedIntervals.last()
                val mergedInterval = Pair(
                    lastInterval.first,
                    max(lastInterval.second, interval.second)
                )
                mergedIntervals[mergedIntervals.size - 1] = mergedInterval
            }
        }

        val ans = mutableListOf<Int>()
        for (interval in mergedIntervals) {
            ans.add(interval.second - interval.first + 1)
        }
        return ans
    }
}