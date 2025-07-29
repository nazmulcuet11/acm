package leetcode

import kotlin.math.max

class LeetCode3480 {
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val maxLefts = List(n + 1) { mutableListOf(0, 0) }
        for (pair in conflictingPairs) {
            pair.sort()
            val l = pair[0]
            val r = pair[1]
            val lefts = maxLefts[r]
            if (l > lefts[1]) {
                lefts[0] = lefts[1]
                lefts[1] = l
            } else if (l > lefts[0]) {
                lefts[0] = l
            }
        }

        val gain = MutableList(n + 1) { 0L }
        var maxGain = 0L
        var ansWithoutRemoving = 0L
        var left = 0
        var secondLeft = 0
        for (r in 1..n) {
            for (l in maxLefts[r]) {
                if (l > left) {
                    secondLeft = left
                    left = l
                } else if (l > secondLeft) {
                    secondLeft = l
                }
            }

            ansWithoutRemoving += r - left
            gain[left] += (left - secondLeft).toLong()
            maxGain = max(maxGain, gain[left])
        }

        return ansWithoutRemoving + maxGain
    }
}