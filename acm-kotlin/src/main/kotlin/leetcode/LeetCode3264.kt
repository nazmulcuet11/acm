package leetcode

import java.util.*

class LeetCode3264 {
    private data class Info(val index: Int, val value: Int)

    private val comparator = Comparator<Info> { a, b ->
        if (a.value == b.value) {
            a.index - b.index
        } else {
            a.value - b.value
        }
    }

    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val pq = PriorityQueue<Info>(comparator)
        for ((i, n) in nums.withIndex()) {
            pq.add(Info(i, n))
        }

        for (i in 0..<k) {
            val t = pq.poll()
            pq.add(Info(t.index, t.value * multiplier))
        }

        val ans = pq
            .toList()
            .sortedBy { it.index }
            .map { it.value }
            .toIntArray()
        return ans
    }
}