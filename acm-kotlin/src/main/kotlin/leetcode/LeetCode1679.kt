package leetcode

import kotlin.math.min

class LeetCode1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {

        val numCount = mutableMapOf<Int, Int>()
        fun getVal(n: Int) = numCount.getOrDefault(n, 0)

        for (n in nums) {
            numCount[n] = getVal(n) + 1
        }

        var ans = 0
        for (x in numCount.keys) {
            ans += min(getVal(x), getVal(k - x))
        }
        return ans / 2
    }
}