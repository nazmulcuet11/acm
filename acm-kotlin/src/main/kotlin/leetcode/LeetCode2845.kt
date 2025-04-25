package leetcode

class LeetCode2845 {
    fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
        val cnt = mutableMapOf<Int, Int>()
        cnt[0] = 1
        var sum = 0
        var ans = 0L
        for (n in nums) {
            if (n % modulo == k) {
                sum++
            }
            ans += cnt.getOrDefault((sum - k + modulo) % modulo, 0)
            cnt[sum % modulo] = cnt.getOrDefault(sum % modulo, 0) + 1
        }
        return ans
    }
}