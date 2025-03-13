package leetcode

import kotlin.math.max

/*
class LeetCode3356 {
    private fun verify(
        nums: IntArray,
        queries: Array<IntArray>,
        k: Int
    ): Boolean {
        val subs = IntArray(nums.size + 1) { 0 }

        // apply queries
        for (i in 0..<k) {
            val q = queries[i]
            subs[q[0]] += q[2]
            subs[q[1] + 1] -= q[2]
        }

        // check if all zeros
        for (i in nums.indices) {
            if (i > 0) {
                subs[i] += subs[i - 1]
            }

            if (nums[i] - subs[i] > 0) {
                return false
            }
        }
        return true
    }

    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        var l = 0
        var r = queries.size
        while (l < r) {
            val m = (l + r) / 2
            if (verify(nums, queries, m)) {
                r = m
            } else {
                l = m + 1
            }
        }

        if (verify(nums, queries, l)) {
            return l
        }
        return -1
    }
}
*/

class LeetCode3356 {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        val subs = IntArray(nums.size + 1) { 0 }
        var qc = 0
        var sum = 0
        for (i in nums.indices) {
            while (sum + subs[i] < nums[i]) {
                qc++
                if (qc > queries.size) {
                    return -1
                }

                val q = queries[qc - 1]
                if (i <= q[1]) {
                    subs[max(i, q[0])] += q[2]
                    subs[q[1] + 1] -= q[2]
                }
            }
            sum += subs[i]
        }
        return qc
    }
}