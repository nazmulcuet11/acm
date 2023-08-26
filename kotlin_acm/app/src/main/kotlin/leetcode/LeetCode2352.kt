package leetcode

class LeetCode2352 {
    private fun transpose(grid: Array<IntArray>): Array<IntArray> {
        if (grid.isEmpty())
            return grid

        val rowCount = grid.size
        val colCount = grid[0].size
        val transposedGrid = Array(colCount) { IntArray(rowCount) }
        for (c in 0..< colCount) {
            for (r in 0..< rowCount) {
                transposedGrid[r][c] = grid[c][r]
            }
        }
        return transposedGrid
    }

    fun equalPairs(grid: Array<IntArray>): Int {
        val rowStringCounts = hashMapOf<String, Int>()
        for (row in grid) {
            val rowString = row.contentToString()
            rowStringCounts[rowString] = rowStringCounts.getOrDefault(rowString, 0) + 1
        }

        var count = 0
        val transposedGrid = transpose(grid)
        for (row in transposedGrid) {
            val rowString = row.contentToString()
            count += rowStringCounts.getOrDefault(rowString, 0)
        }

        return count
    }
}