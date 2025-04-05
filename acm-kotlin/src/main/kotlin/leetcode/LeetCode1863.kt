package leetcode

class LeetCode1863 {
    fun subsetXORSum(nums: IntArray): Int {
        val subsetXorList = mutableListOf<Int>()
        fun generate(i: Int, subsetXor: Int) {
            if (i >= nums.size) {
                subsetXorList.add(subsetXor)
                return
            }

            generate(i + 1, subsetXor)
            generate(i + 1, subsetXor xor nums[i])
        }

        generate(0, 0)

        var sum = 0
        for (subsetXor in subsetXorList) {
            sum += subsetXor
        }

        return sum
    }
}