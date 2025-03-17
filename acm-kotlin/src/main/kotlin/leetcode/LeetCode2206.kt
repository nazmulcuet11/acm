package leetcode

class LeetCode2206 {
    fun divideArray(nums: IntArray): Boolean {
        val mp = mutableMapOf<Int, Int>()
        for(n in nums) {
            mp[n] = mp.getOrDefault(n, 0) + 1
        }

        for ((key, value) in mp) {
            if (value % 2 == 1) {
                return false
            }
        }
        return true
    }
}