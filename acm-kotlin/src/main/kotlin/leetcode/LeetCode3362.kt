package leetcode

import java.util.*
import kotlin.math.max

class LeetCode3362 {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
        queries.sortBy { it[0] }
        val subs = IntArray(nums.size + 1) { 0 }
        val pq = PriorityQueue<IntArray>(compareByDescending { it[1] })
        var qc = 0
        var qi = 0
        var sum = 0
        for (i in nums.indices) {
            while (qi < queries.size && queries[qi][0] <= i) {
                pq.add(queries[qi])
                qi++
            }

            while (sum + subs[i] < nums[i]) {
                if (pq.isEmpty()) {
                    return -1
                }

                val q = pq.poll()
                if (i <= q[1]) {
                    subs[max(i, q[0])] += 1
                    subs[q[1] + 1] -= 1
                    qc++
                }
            }
            sum += subs[i]
        }

        return queries.size - qc
    }
}