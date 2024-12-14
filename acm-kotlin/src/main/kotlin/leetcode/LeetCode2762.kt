package leetcode

/*
// Segment tree solution: Supposed to work as it is O(NlogN) but somehow getting TLE
class LeetCode2762 {
    private companion object {
        const val MAX_N = 100005
    }

    private data class MinMax(val min: Int, val max: Int) {
        fun diff() = max - min
    }

    private val tree = Array<MinMax>(4 * MAX_N) { MinMax(-1, -1) }

    private fun buildTree(i: Int, nums: IntArray, sl: Int, sr: Int): MinMax {
        if (sl == sr) {
            tree[i] = MinMax(nums[sl], nums[sl])
        } else {
            val m = sl + (sr - sl) / 2
            val lc = buildTree(2 * i + 1, nums, sl, m)
            val rc = buildTree(2 * i + 2, nums, m + 1, sr)
            tree[i] = MinMax(min(lc.min, rc.min), max(lc.max, rc.max))
        }
        return tree[i]
    }

    private fun buildTree(nums: IntArray) {
        buildTree(0, nums, 0, nums.size - 1)
    }

    private fun query(i: Int, sl: Int, sr: Int, ql: Int, qr: Int): MinMax {
        if (ql <= sl && sr <= qr) {
            return tree[i]
        }

        if (qr < sl || ql > sr) {
            return MinMax(Int.MAX_VALUE, Int.MIN_VALUE)
        }

        val m = sl + (sr - sl) / 2
        val lc = query(2 * i + 1, sl, m, ql, qr)
        val rc = query(2 * i + 2, m + 1, sr, ql, qr)
        return MinMax(min(lc.min, rc.min), max(lc.max, rc.max))
    }

    private fun query(nums: IntArray, ql: Int, qr: Int): MinMax {
        return query(0, 0, nums.size - 1, ql, qr)
    }

    fun continuousSubarrays(nums: IntArray): Long {
        buildTree(nums)

        var i = 0
        var j = 0
        var ans = 0L
        while (j < nums.size) {
            val diff = query(nums, i, j).diff()
            if (diff > 2) {
                i++
            } else {
                ans += j - i + 1
                j++
            }
        }
        return ans
    }
}
*/

// MONO QUEUE Solution. O(N)
class LeetCode2762 {
    private class MinMaxQueue {
        private val queue = ArrayDeque<Int>()
        private val maxQueue = ArrayDeque<Int>()
        private val minQueue = ArrayDeque<Int>()

        fun push(n: Int) {
            queue.add(n)

            while (maxQueue.isNotEmpty() && maxQueue.last() < n) {
                maxQueue.removeLast()
            }
            maxQueue.add(n)

            while (minQueue.isNotEmpty() && minQueue.last() > n) {
                minQueue.removeLast()
            }
            minQueue.add(n)
        }

        fun pop(): Int {
            val t = queue.removeFirst()
            if (t == maxQueue.first()) {
                maxQueue.removeFirst()
            }
            if (t == minQueue.first()) {
                minQueue.removeFirst()
            }
            return t
        }

        val min
            get() = minQueue.first()

        val max
            get() = maxQueue.first()

        val diff
            get() = max - min

        val size
            get() = queue.size

        fun isNotEmpty() = queue.isNotEmpty()
    }

    fun continuousSubarrays(nums: IntArray): Long {
        var i = 0
        var ans = 0L
        val monoQueue = MinMaxQueue()
        while (i < nums.size) {
            monoQueue.push(nums[i])
            while (monoQueue.isNotEmpty() && monoQueue.diff > 2) {
                monoQueue.pop()
            }
            ans += monoQueue.size
            i++
        }
        return ans
    }
}
