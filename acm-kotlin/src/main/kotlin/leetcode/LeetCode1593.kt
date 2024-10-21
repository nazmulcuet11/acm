package leetcode

import kotlin.math.max

class LeetCode1593 {
    private var ans = 0
    private var str = ""
    private val subs = mutableSetOf<String>()

    private fun solve(i: Int, j: Int) {
        // prune/optimize
        if ((subs.size + 1 + str.length - i) < ans) {
            return
        }

        val sub = str.substring(i, j)

        if (j == str.length) {
            if (sub !in subs) {
                ans = maxOf(ans, subs.size + 1)
            }
            return
        }

        if (sub !in subs) {
            subs.add(sub)
            solve(j, j + 1)
            subs.remove(sub)
        }
        solve(i, j + 1)
    }

    fun maxUniqueSplit(s: String): Int {
        ans = 0
        str = s
        subs.clear()
        solve(0, 1)
        return ans
    }
}