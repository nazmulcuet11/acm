package leetcode

import kotlin.math.max

class LeetCode1072 {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val rowMap = mutableMapOf<String, Int>()
        var ans = 0
        for (i in matrix.indices) {
            val row = matrix[i]
            if (row[0] == 1) {
                for (j in row.indices) {
                    row[j] = (row[j] + 1) % 2 // flip
                }
            }

            val key = row.toList().toString()
            rowMap[key] = rowMap.getOrDefault(key, 0) + 1
            ans = max(ans, rowMap.getOrDefault(key, 0))
        }
        return ans
    }
}