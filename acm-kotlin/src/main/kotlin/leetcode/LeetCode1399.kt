package leetcode

class LeetCode1399 {
    fun countLargestGroup(n: Int): Int {
        val groupSize = mutableMapOf<Int, Int>()
        for (i in 1..n) {
            val s = i.toString().map { it.digitToInt() }.sum()
            groupSize[s] = groupSize.getOrDefault(s, 0) + 1
        }

        val maxGroupSize = groupSize.values.max()
        val ans = groupSize.values.count { it == maxGroupSize }
        return ans
    }
}