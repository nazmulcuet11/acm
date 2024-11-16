package leetcode

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