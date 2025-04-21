package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode2145 {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var curr = lower.toLong()
        var mn = lower.toLong()
        var mx = lower.toLong()
        for (diff in differences) {
            curr += diff
            mn = min(mn, curr)
            mx = max(mx, curr)
        }

        val offset = lower - mn
        return max(0, upper - mx - offset + 1).toInt()
    }
}