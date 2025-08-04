package leetcode

import kotlin.math.max

class LeetCode904 {
    fun totalFruit(fruits: IntArray): Int {
        val n = fruits.size
        var i = 0
        var j = 0
        val uniqueTypes = mutableSetOf<Int>()
        val lastIndex = IntArray(n) { -1 }
        var ans = 0
        while (j < n) {
            uniqueTypes.add(fruits[j])
            lastIndex[fruits[j]] = j
            j++

            while (uniqueTypes.size > 2) {
                if (i == lastIndex[fruits[i]]) {
                    uniqueTypes.remove(fruits[i])
                }
                i++
            }

            ans = max(ans, j - i)
        }
        return ans
    }
}