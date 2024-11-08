package leetcode

class LeetCode1829 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val answers = mutableListOf<Int>()
        var x = 0
        for (n in nums) {
            x = x xor n
        }

        for (i in nums.size - 1 downTo 0) {
            var ans = 0
            for (j in 0..<maximumBit) {
                if (x and (1 shl j) == 0) {
                    ans = ans or (1 shl j)
                }
            }
            answers.add(ans)
            x = x xor nums[i]
        }
        return answers.toIntArray()
    }
}