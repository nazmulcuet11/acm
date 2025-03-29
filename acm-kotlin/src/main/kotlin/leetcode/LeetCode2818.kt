package leetcode

import java.util.*
import kotlin.math.min

class LeetCode2818 {
    fun maximumScore(nums: List<Int>, k: Int): Int {
        val mod = 1_000_000_000 + 7L

        fun score(n: Int): Int {
            var x = n
            var f = 2
            var score = 0
            while (f * f <= x) {
                if (x % f == 0) {
                    while (x % f == 0) {
                        x /= f
                    }
                    score++
                }
                f++
            }

            if (x >= 2) {
                score++
            }

            return score
        }

        fun bigPow(a: Long, p: Long): Long {
            if (p == 0L) {
                return 1
            }

            var r = bigPow(a, p / 2)
            r = (r * r) % mod
            if (p % 2 == 1L) {
                r = (r * a) % mod
            }
            return r
        }

        val scores = nums.map { score(it) }

        val left = IntArray(nums.size) { -1 }
        val right = IntArray(nums.size) { nums.size }
        val stack = Stack<Int>()
        for (i in scores.indices) {
            while (stack.isNotEmpty() && scores[stack.peek()] < scores[i]) {
                val j = stack.pop()
                right[j] = i
            }
            if (stack.isNotEmpty()) {
                left[i] = stack.peek()
            }
            stack.add(i)
        }

        data class QueueEntry(val value: Int, val count: Long)

        val comparator = Comparator<QueueEntry> { a, b -> b.value - a.value }

        val pq = PriorityQueue(comparator)
        for (i in nums.indices) {
            val count = (i - left[i]).toLong() * (right[i] - i).toLong()
            pq.add(QueueEntry(nums[i], count))
        }

        var remaining = k.toLong()
        var ans = 1L
        while (remaining > 0) {
            val e = pq.poll()
            val t = bigPow(e.value.toLong(), min(e.count, remaining))
            ans = (ans * t) % mod
            remaining -= min(e.count, remaining)
        }

        return ans.toInt()
    }
}