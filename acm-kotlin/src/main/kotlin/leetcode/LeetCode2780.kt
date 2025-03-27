package leetcode

class LeetCode2780 {
    fun minimumIndex(nums: List<Int>): Int {
        val count = mutableMapOf<Int, Int>()
        fun getCount(n: Int) = count.getOrDefault(n, 0)
        var max = -1
        for (n in nums) {
            count[n] = getCount(n) + 1
            if (getCount(n) > getCount(max)) {
                max = n
            }
        }

        var leftCount = 0
        for ((i, n) in nums.withIndex()) {
            if (max == n) {
                leftCount++
            }

            if ((leftCount * 2 > i + 1) && (getCount(max) - leftCount) * 2 > (nums.size - i - 1)) {
                return i
            }
        }
        return -1
    }
}