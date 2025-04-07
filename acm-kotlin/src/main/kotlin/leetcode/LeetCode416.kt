package leetcode

class LeetCode416 {
    private fun Int.toBool() = this != 0
    private fun Boolean.toInt() = if (this) 1 else 0

    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 == 1) {
            return false
        }

        val cache = Array<IntArray>(nums.size) { IntArray(21000) { -1 } }
        fun solve(i: Int, sum: Int): Boolean {
            if (i == nums.size) {
                return sum * 2 == total
            }

            if (cache[i][sum] != -1) {
                return cache[i][sum].toBool()
            }

            val a = solve(i + 1, sum)
            val b = solve(i + 1, sum + nums[i])
            val result = a || b
            cache[i][sum] = result.toInt()
            return result
        }

        return solve(0,0)
    }
}
