package leetcode.weekly431

import kotlin.math.max

class Question1 {
    private fun gcd(a: Long, b: Long): Long {
        if (b == 0L) {
            return a
        }
        return gcd(b, a % b)
    }

    private fun gcd(nums: IntArray, s: Int, e: Int): Long {
        var g = gcd(nums[s].toLong(), nums[s].toLong())
        for (i in s + 1..e) {
            g = gcd(g, nums[i].toLong())
        }
        return g
    }

    private fun lcm(nums: IntArray, s: Int, e: Int): Long {
        val g = gcd(nums, s, e)
        var l = nums[s].toLong()
        for (i in s + 1..e) {
            l = (l * nums[i].toLong()) / gcd(l, nums[i].toLong())
        }
        return l
    }

    private fun prod(nums: IntArray, s: Int, e: Int): Long {
        var l = 1L
        for (i in s..e) {
            l *= nums[i]
        }
        return l
    }

    fun maxLength(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            for (j in i..<nums.size) {
                if (prod(nums, i, j) == lcm(nums, i, j) * gcd(nums, i, j)) {
                    ans = max(ans, j - i + 1)
                }
            }
        }
        return ans
    }
}