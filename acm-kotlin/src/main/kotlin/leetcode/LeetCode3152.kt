package leetcode

class LeetCode3152 {
    private fun isEven(a: Int) = a % 2 == 0
    private fun isOdd(a: Int) = !isEven(a)
    private fun isSameParity(a: Int, b: Int) = (isEven(a) && isEven(b)) || (isOdd(a) && isOdd(b))

    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val count = IntArray(nums.size) { 0 }
        for (i in 1..<nums.size) {
            val v = if (isSameParity(nums[i - 1], nums[i])) 1 else 0
            count[i] = count[i - 1] + v
        }

        val ans = BooleanArray(queries.size) { false }
        for ((i, q) in queries.withIndex()) {
            ans[i] = count[q[1]] - count[q[0]] == 0
        }
        return ans
    }
}
