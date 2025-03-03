package leetcode

class LeetCode2161 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val ans = IntArray(nums.size) { pivot }
        var x = 0
        for (n in nums) {
            if (n < pivot) {
                ans[x] = n
                x++
            }
        }

        var y = nums.size - 1
        for (n in nums.reversed()) {
            if (n > pivot) {
                ans[y] = n
                y--
            }
        }

        return ans
    }
}