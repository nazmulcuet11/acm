package leetcode

class LeetCode2226 {
    private fun verify(candies: IntArray, k: Long, candy: Int): Boolean {
        var count = 0L
        for (c in candies) {
            count += c / candy
        }
        return count >= k
    }

    fun maximumCandies(candies: IntArray, k: Long): Int {
        var l = 0
        var r = candies.max()
        while (l < r) {
            val m = (l + r + 1) / 2
            if (verify(candies, k, m)) {
                l = m
            } else {
                r = m - 1
            }
        }
        return l
    }
}