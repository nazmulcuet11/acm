package leetcode

class LeetCode2028 {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val totalSum = mean * (rolls.size + n)
        val rollsSum = rolls.sum()
        val missingSum = totalSum - rollsSum
        if (missingSum < n || missingSum > 6 * n) {
            return intArrayOf()
        } else {
            val floorAvg = missingSum / n
            val extra = missingSum - n * floorAvg
            val missing = mutableListOf<Int>()
            for (i in 0..<n) {
                if (i < extra) {
                    missing.add(floorAvg + 1)
                } else {
                    missing.add(floorAvg)
                }
            }
            return missing.toIntArray()
        }
    }
}