package leetcode

/*
class LeetCode3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val ans = mutableListOf<Int>()
        val dq = ArrayDeque<Int>()
        for ((i, n) in nums.withIndex()) {
            if (dq.size > 0 && dq.last() + 1 != n) {
                dq.clear()
            }
            dq.add(n)
            if (dq.size > k) {
                dq.removeFirst()
            }

            if (i >= k - 1) {
                if (dq.size == k) {
                    ans.add(n)
                } else {
                    ans.add(-1)
                }
            }
        }
        return ans.toIntArray()
    }
}
*/

class LeetCode3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val ans = mutableListOf<Int>()
        var l = 0
        var r = 0
        for ((i, n) in nums.withIndex()) {
            if (r - l + 1 > 0 && nums[r] + 1 != n) {
                l = i
            }
            r = i
            if (r - l + 1 > k) {
                l++
            }

            if (i >= k - 1) {
                if (r - l + 1 == k) {
                    ans.add(n)
                } else {
                    ans.add(-1)
                }
            }
        }
        return ans.toIntArray()
    }
}