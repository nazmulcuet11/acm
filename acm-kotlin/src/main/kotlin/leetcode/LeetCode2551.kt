package leetcode

import java.util.*

class LeetCode2551 {
    fun putMarbles(weights: IntArray, k: Int): Long {
        fun solve(heap: PriorityQueue<Long>): Long {
            for (i in 0..<weights.size - 1) {
                heap.add(weights[i].toLong() + weights[i + 1].toLong())
            }

            var ans = weights.first().toLong() + weights.last().toLong()
            for (x in 0..<k - 1) {
                ans += heap.poll()
            }
            return ans
        }

        val max = solve(PriorityQueue<Long> { a, b -> (b - a).toInt() })
        val min = solve(PriorityQueue<Long> { a, b -> (a - b).toInt() })

        return max - min
    }
}