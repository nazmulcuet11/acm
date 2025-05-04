package leetcode

class LeetCode1128 {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val dominoCount = mutableMapOf<List<Int>, Int>()
        fun getCount(key: List<Int>) = dominoCount.getOrDefault(key, 0)

        var ans = 0
        for (domino in dominoes) {
            val key = domino.sorted()
            ans += getCount(key)
            dominoCount[key] = getCount(key) + 1
        }
        return ans
    }
}