package leetcode

class LeetCode689 {
    private data class Info(
        val maxValue: Long,
        val maxValueIndices: List<Int>
    )

    private var k = 0
    private var nums = intArrayOf()
    private var cumSum = intArrayOf()
    private var cache = mutableMapOf<Pair<Int, Int>, Info>()

    private fun solve(i: Int, c: Int): Info {
        if (c == 0 || i >= nums.size) {
            return Info(0, listOf())
        }

        val key = Pair(i, c)
        cache[key]?.let { return it }

        // take ith element
        val x = solve(i + k, c - 1)
        var ans = Info(cumSum[i] + x.maxValue, listOf(i) + x.maxValueIndices)
        // skip ith element
        val y = solve(i + 1, c)
        // take maximum
        if (y.maxValue > ans.maxValue) {
            ans = y
        }
        cache[key] = ans
        return ans
    }

    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        this.k = k
        this.nums = nums
        this.cumSum = IntArray(nums.size)
        var sum = 0
        for (i in 0..<k) {
            sum += nums[i]
        }
        this.cumSum[0] = sum
        for (i in 1..<nums.size - k + 1) {
            sum += nums[i + k - 1]
            sum -= nums[i - 1]
            this.cumSum[i] = sum
        }
        this.cache = mutableMapOf<Pair<Int, Int>, Info>()
        val ans = solve(0, 3)
        return ans.maxValueIndices.toIntArray()
    }
}