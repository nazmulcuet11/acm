package leetcode

class LeetCode2560 {
    private fun verify(nums: IntArray, k: Int, c: Int): Boolean {
        var count = 0
        var i = 0
        while (i < nums.size) {
            var x = 0
            while (i < nums.size && nums[i] <= c) {
                x++
                i++
            }
            count += (x + 1) / 2
            i++
        }

        return count >= k
    }

    fun minCapability(nums: IntArray, k: Int): Int {
        var l = 1
        var r = nums.max()
        while (l < r) {
            val m = (l + r) / 2
            if (verify(nums, k, m)) {
                r = m
            } else {
                l = m + 1
            }
        }
        return l
    }
}