package leetcode

class LeetCode2799 {
    fun countCompleteSubarrays(nums: IntArray): Int {
        var totalDistinctCount = 0
        val count = mutableMapOf<Int, Int>()
        for (n in nums) {
            count[n] = count.getOrDefault(n, 0) + 1
            if (count[n] == 1) {
                totalDistinctCount++
            }
        }

        var i = 0
        var j = 0
        var distinctCount = 0
        var ans = 0
        count.clear()
        while (j < nums.size) {
            count[nums[j]] = count.getOrDefault(nums[j], 0) + 1
            if (count[nums[j]] == 1) {
                distinctCount++
            }

            while (distinctCount == totalDistinctCount) {
                ans += nums.size - j
                count[nums[i]] = count.getOrDefault(nums[i], 0) - 1
                if (count[nums[i]] == 0) {
                    distinctCount--
                }
                i++
            }

            j++
        }
        return ans
    }
}