package leetcode

class LeetCode3375 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val numSet = mutableSetOf<Int>()
        for (n in nums) {
            numSet.add(n)
        }

        return if (k > numSet.min()) {
            -1
        } else if (k < numSet.min()) {
            numSet.size
        } else {
            numSet.size - 1
        }
    }
}