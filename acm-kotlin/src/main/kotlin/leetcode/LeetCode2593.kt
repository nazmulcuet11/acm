package leetcode

import java.util.*

class LeetCode2593 {
    private val comparator = Comparator<Pair<Int, Int>> { a, b ->
        if (a.first == b.first) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }

    fun findScore(nums: IntArray): Long {
        val marked = BooleanArray(nums.size) { false }
        val pq = PriorityQueue<Pair<Int, Int>>(comparator)
        for ((i, n) in nums.withIndex()) {
            pq.add(Pair(n, i))
        }
        var sum = 0L
        while (pq.isNotEmpty()) {
            val (value, index) = pq.poll()
            if (!marked[index]) {
                sum += value
                marked[index] = true
                if (index - 1 >= 0) {
                    marked[index - 1] = true
                }
                if (index + 1 < nums.size) {
                    marked[index + 1] = true
                }
            }
        }
        return sum
    }
}