package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3489 {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        // minQueryToSolve(index: Int) returns minimum number of query
        // required to make nums[i] == 0
        fun minQueryToSolve(index: Int): Int {
            val cache = Array(queries.size) { IntArray(nums[index] + 1) { -1 } }

            fun solve(k: Int, x: Int): Int {
                if (x == 0) {
                    return k
                }

                if (x < 0 || k == queries.size) {
                    return Int.MAX_VALUE
                }

                if (cache[k][x] != -1) {
                    return cache[k][x]
                }

                // do not take kth query
                var ans = solve(k + 1, x)
                if (queries[k][0] <= index && index <= queries[k][1] && x - queries[k][2] >= 0) {
                    // take kth query
                    ans = min(ans, solve(k + 1, x - queries[k][2]))
                }
                cache[k][x] = ans
                return ans
            }

            return solve(0, nums[index])
        }

        var mx = 0
        for (i in nums.indices) {
            mx = max(mx, minQueryToSolve(i))
        }
        return if (mx == Int.MAX_VALUE) -1 else mx
    }
}