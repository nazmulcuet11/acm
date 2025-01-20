package leetcode

class LeetCode2661 {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rowUnpaintedCellCount = IntArray(m) { n }
        val columnUnpaintedCellCount = IntArray(n) { m }
        val valueToIndex = mutableMapOf<Int, Pair<Int, Int>>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                val v = mat[i][j]
                valueToIndex[v] = Pair(i, j)
            }
        }
        for ((x, v) in arr.withIndex()) {
            valueToIndex[v]?.let {
                val i = it.first
                val j = it.second
                rowUnpaintedCellCount[i]--
                columnUnpaintedCellCount[j]--
                if (rowUnpaintedCellCount[i] == 0 || columnUnpaintedCellCount[j] == 0) {
                    return x
                }
            }
        }
        return arr.size
    }
}