package leetcode

import kotlin.math.ceil

class LeetCode781 {
    fun numRabbits(answers: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        for (a in answers) {
            count[a] = count.getOrDefault(a, 0) + 1
        }

        var ans = 0
        for ((n, value) in count) {
            val groups = ceil(value.toDouble() / (n + 1)).toInt()
            ans += groups * (n + 1)
        }
        return ans
    }
}