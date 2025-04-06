package leetcode

class LeetCode368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()

        val cache = MutableList<Int>(nums.size) { -1 }
        val next = MutableList<Int>(nums.size) { -1 }
        fun solve(i: Int): Int {
            if (i >= nums.size) {
                return 0
            }

            if (cache[i] != -1) {
                return cache[i]
            }

            var maxLen = 1
            for (j in i + 1..<nums.size) {
                if (nums[j] % nums[i] == 0) {
                    val len = solve(j) + 1
                    if (len > maxLen) {
                        maxLen = len
                        next[i] = j
                    }
                }
            }
            cache[i] = maxLen
            return cache[i]
        }

        for (i in nums.indices) {
            solve(i)
        }

        var maxStart = 0
        for (i in nums.indices) {
            if (cache[i] > cache[maxStart]) {
                maxStart = i
            }
        }

        val ans = mutableListOf<Int>()
        var curr = maxStart
        while (curr != -1) {
            ans.add(nums[curr])
            curr = next[curr]
        }
        return ans
    }
}