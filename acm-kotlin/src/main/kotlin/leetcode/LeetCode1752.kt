package leetcode

class LeetCode1752 {
    fun check(nums: IntArray): Boolean {
        val rotatePoints = mutableListOf<Int>()
        for (i in 1..<nums.size) {
            if (nums[i - 1] > nums[i]) {
                rotatePoints.add(i)
            }
        }

        return if (rotatePoints.size == 0) {
            true
        } else if (rotatePoints.size == 1) {
            nums.first() >= nums.last()
        } else {
            false
        }
    }
}