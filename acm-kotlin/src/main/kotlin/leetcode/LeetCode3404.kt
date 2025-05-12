package leetcode

class LeetCode3404 {
    fun numberOfSubsequences(nums: IntArray): Long {
        fun gcd(a: Int, b: Int): Int {
            if (a % b == 0) {
                return b
            }
            return gcd(b, a % b)
        }

        data class Ratio(val x: Int, val y: Int)

        var ans = 0L
        val map = mutableMapOf<Ratio, Int>()

        for (r in nums.indices) {
            for (s in r + 2..<nums.size) {
                val g = gcd(nums[r], nums[s])
                val ratio = Ratio(nums[s] / g, nums[r] / g)
                ans += map.getOrDefault(ratio, 0)
            }

            val q = r - 1
            for (p in q - 2 downTo 0) {
                val g = gcd(nums[p], nums[q])
                val ratio = Ratio(nums[p] / g, nums[q] / g)
                map[ratio] = map.getOrDefault(ratio, 0) + 1
            }
        }
        return ans
    }
}