package leetcode

class LeetCode494 {
    private fun compute(
        nums: IntArray,
        i: Int,
        target: Int,
        cache: MutableMap<Pair<Int, Int>, Int>
    ): Int {
        if (i == nums.size) {
            return if (target == 0) 1 else 0
        }

        val key = Pair(i, target)
        cache[key]?.let { return it }
        val ans = compute(nums, i + 1, target - nums[i], cache) + compute(nums, i + 1, target + nums[i], cache)
        cache[key] = ans
        return ans
    }

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return compute(nums, 0, target, mutableMapOf())
    }
}