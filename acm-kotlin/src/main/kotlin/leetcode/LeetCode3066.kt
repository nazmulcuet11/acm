package leetcode

import java.util.*

class LeetCode3066 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Long>()
        for (n in nums) {
            pq.add(n.toLong())
        }

        var operation = 0
        while (pq.size > 1) {
            val a = pq.poll()
            val b = pq.poll()
            if (a >= k) {
                break
            }
            pq.add(a * 2 + b)
            operation++
        }
        return operation
    }
}