package leetcode

class LeetCode1861 {
    private fun moveIfPossible(row: CharArray, i: Int) {
        var j = i
        while (j + 1 < row.size && row[j + 1] == '.') {
            j++
        }

        if (j != i) {
            row[j] = '#'
            row[i] = '.'
        }
    }

    private fun solve(row: CharArray) {
        for (i in row.indices.reversed()) {
            if (row[i] == '#') {
                moveIfPossible(row, i)
            }
        }
    }

    private fun getCol(box: Array<CharArray>, i: Int): CharArray {
        val col = mutableListOf<Char>()
        for (r in box.indices) {
            col.add(box[r][i])
        }
        return col.reversed().toCharArray()
    }

    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        for (row in box) {
            solve(row)
        }

        val ans = mutableListOf<CharArray>()
        for (i in 0..<box[0].size) {
            ans.add(getCol(box, i))
        }

        return ans.toTypedArray()
    }
}