package leetcode

class LeetCode1863 {
    fun subsetXORSum(nums: IntArray): Int {
        val subsets = mutableListOf<List<Int>>()
        fun generate(i: Int, subset: List<Int>) {
            if (i >= nums.size) {
                subsets.add(subset)
                return
            }

            generate(i + 1, subset)
            generate(i + 1, subset + listOf(nums[i]))
        }

        generate(0, listOf())

        fun subsetXor(subset: List<Int>): Int {
            var ans = 0
            for (n in subset) {
                ans = ans xor n
            }
            return ans
        }

        var sum = 0
        for (subset in subsets) {
            sum += subsetXor(subset)
        }

        return sum
    }
}