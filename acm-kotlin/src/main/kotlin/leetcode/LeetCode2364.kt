package leetcode

class LeetCode2364 {
    fun countBadPairs(nums: IntArray): Long {
        val diffCount = mutableMapOf<Int, Int>()
        var goodPairCount = 0L
        for ((i, n) in nums.withIndex()) {
            val diff = n - i
            val oldCount = diffCount.getOrDefault(diff, 0)
            goodPairCount += oldCount
            diffCount[diff] = oldCount + 1
        }
        val n = nums.size.toLong()
        val totalPairCount = (n * (n - 1)) / 2
        return totalPairCount - goodPairCount
    }
}