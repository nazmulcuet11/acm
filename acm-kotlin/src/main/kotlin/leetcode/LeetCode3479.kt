package leetcode

import kotlin.math.max

class LeetCode3479 {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val n = fruits.size

        val tree = IntArray(4 * n) { -1 }

        fun build(node: Int, rangeStart: Int, rangeEnd: Int) {
            if (rangeStart == rangeEnd) {
                tree[node] = baskets[rangeStart]
                return
            }

            val mid = (rangeStart + rangeEnd) / 2
            val left = node * 2 + 1
            val right = node * 2 + 2

            build(left, rangeStart, mid)
            build(right, mid + 1, rangeEnd)

            tree[node] = max(tree[left], tree[right])
        }

        build(0, 0, n - 1)

        fun invalidate(node: Int, rangeStart: Int, rangeEnd: Int, index: Int) {
            if (rangeStart == rangeEnd) {
                tree[node] = -1
                baskets[index] = -1
                return
            }

            val mid = (rangeStart + rangeEnd) / 2
            val left = node * 2 + 1
            val right = node * 2 + 2

            if (index <= mid) {
                invalidate(left, rangeStart, mid, index)
            } else {
                invalidate(right, mid + 1, rangeEnd, index)
            }

            tree[node] = max(tree[left], tree[right])
        }

        fun query(node: Int, rangeStart: Int, rangeEnd: Int, fruit: Int): Int {
            if (tree[node] < fruit) {
                return Int.MAX_VALUE
            }

            if (rangeStart == rangeEnd) {
                return rangeStart
            }

            val mid = (rangeStart + rangeEnd) / 2
            val left = node * 2 + 1
            val right = node * 2 + 2

            return if (tree[left] >= fruit) {
                query(left, rangeStart, mid, fruit)
            } else {
                query(right, mid + 1, rangeEnd, fruit)
            }
        }

        var ans = 0
        for (f in fruits) {
            val basketIndex = query(0, 0, n - 1, f)
            if (basketIndex == Int.MAX_VALUE) {
                ans++
            } else {
                invalidate(0, 0, n - 1, basketIndex)
            }
        }

        return ans
    }
}