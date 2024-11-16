package leetcode

class LeetCode3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val ans = mutableListOf<Int>()
        var r = k - 1
        var l = k - 1
        while (l > 0 && nums[l - 1] + 1 == nums[l])
            l--
        println("l: $l")
        if (r - l + 1 == k) {
            ans.add(nums[r])
        } else {
            ans.add(-1)
        }

        for (i in k..<nums.size) {
            if (nums[i] != nums[r] + 1) {
                l = i
            }
            r = i
            if (r - l + 1 > k) {
                l++
            }

            if (r - l + 1 == k) {
                ans.add(nums[i])
            } else {
                ans.add(-1)
            }
        }
        return ans.toIntArray()
    }
}