package leetcode

import kotlin.math.min

/*
class LeetCode862 {
    data class Info(
        val sum: Long,
        val index: Int
    ): Comparable<Info> {
        override fun compareTo(other: Info): Int {
            return if (sum < other.sum) {
                -1
            } else if (sum > other.sum) {
                1
            } else {
                0
            }
        }
    }

    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Info>()
        heap.add(Info(0, -1))
        var sum = 0L
        var ans = Int.MAX_VALUE
        for ((i, n) in nums.withIndex()) {
            sum += n
            while (heap.isNotEmpty() && sum - heap.peek().sum >= k) {
                ans = min(ans, i - heap.poll().index)
            }
            heap.add(Info(sum, i))
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}
*/

class LeetCode862 {
    data class Info(
        val sum: Long,
        val index: Int
    )

    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val deque = ArrayDeque<Info>()
        deque.add(Info(0, -1))
        var sum = 0L
        var ans = Int.MAX_VALUE
        for ((i, n) in nums.withIndex()) {
            sum += n
            while (deque.isNotEmpty() && sum - deque.first().sum >= k) {
                ans = min(ans, i - deque.first().index)
                deque.removeFirst()
            }
            while (deque.isNotEmpty() && deque.last().sum >= sum) {
                deque.removeLast()
            }
            deque.add(Info(sum, i))
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}