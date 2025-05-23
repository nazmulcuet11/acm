package leetcode

import kotlin.math.max

class LeetCode3068 {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
        fun xorOf(x: Long): Long = x xor k.toLong()
        fun xorOf(x: Int): Long = xorOf(x.toLong())

        val p = mutableListOf<Long>()
        val q = mutableListOf<Long>()
        for (n in nums) {
            val t = xorOf(n)
            if (t > n) {
                p.add(t)
            } else {
                q.add(n.toLong())
            }
        }

        val a = p.sum()
        val b = q.sum()

        if (p.size % 2 == 0) {
            return a + b
        }

        var c = 0L
        for (x in p) {
            c = max(c, a - x + xorOf(x))
        }

        if (q.size == 0) {
            return c
        }

        var d = 0L
        for (x in q) {
            d = max(d, b - x + xorOf(x))
        }

        return max(a + d, b + c)
    }
}