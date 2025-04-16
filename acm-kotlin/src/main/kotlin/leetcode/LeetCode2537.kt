package leetcode

class LeetCode2537 {
    fun countGood(nums: IntArray, k: Int): Long {
        var ans = 0L
        var i = 0
        var j = 0
        val frequency = mutableMapOf<Int, Int>()
        var count = 0L
        while (j < nums.size) {
            var n = nums[j]
            count += frequency.getOrDefault(n, 0)
            frequency[n] = frequency.getOrDefault(n, 0) + 1

            while (count >= k) {
                n = nums[i]
                frequency[n] = frequency.getOrDefault(n, 0) - 1
                count -= frequency.getOrDefault(n, 0)
                ans += nums.size - j
                i++
            }

            j++
        }
        return ans
    }
}