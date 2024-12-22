package leetcode

import kotlin.math.max

class LeetCode2940 {
    private companion object {
        const val MAX_SIZE = 5 * 10001
    }

    private val tree = IntArray(4 * MAX_SIZE) { 0 }

    private fun leftChild(i: Int) = 2 * i + 1

    private fun rightChild(i: Int) = 2 * i + 2

    private fun midPoint(l: Int, r: Int) = l + (r - l) / 2

    private fun buildTree(heights: IntArray, i: Int, sl: Int, sr: Int) {
        if (sl == sr) {
            println("$i $sl")
            tree[i] = heights[sl]
            return
        }

        val lc = leftChild(i)
        val rc = rightChild(i)
        val m = midPoint(sl, sr)
        buildTree(heights, lc, sl, m)
        buildTree(heights, rc, m + 1, sr)
        tree[i] = max(tree[lc], tree[rc])
    }

    private fun buildTree(heights: IntArray) {
        buildTree(heights, 0, 0, heights.size - 1)
    }

    private fun maxInRange(i: Int, sl: Int, sr: Int, ql: Int, qr: Int): Int {
        if (ql <= sl && sr <= qr) {
            return tree[i]
        }

        if (sr < ql || sl > qr) {
            return -1
        }

        val lc = leftChild(i)
        val rc = rightChild(i)
        val m = midPoint(sl, sr)
        return max(
            maxInRange(lc, sl, m, ql, qr),
            maxInRange(rc, m + 1, sr, ql, qr)
        )
    }

    private fun maxInRange(heights: IntArray, ql: Int, qr: Int): Int {
        return maxInRange(0, 0, heights.size - 1, ql, qr)
    }

    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        buildTree(heights)

        val ans = IntArray(queries.size) { -1 }
        for ((i, q) in queries.withIndex()) {
            var x = q[0]
            var y = q[1]
            if (x > y) {
                x = y.also { y = x }
            }

            if (x == y || heights[x] < heights[y]) {
                ans[i] = y
            } else {
                var l = y + 1
                var r = heights.size - 1
                while (l < r) {
                    val m = midPoint(l, r)
                    if (maxInRange(heights, l, m) > heights[x]) {
                        r = m
                    } else if (maxInRange(heights, m + 1, r) > heights[x]) {
                        l = m + 1
                    } else {
                        break
                    }
                }

                if (l < heights.size && heights[l] > heights[x]) {
                    ans[i] = l
                }
            }
        }
        return ans
    }
}