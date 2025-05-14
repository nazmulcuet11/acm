package leetcode

class LeetCode3337 {
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val mod = (1e9 + 7).toInt()

        fun Char.index() = code - 'a'.code

        fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
            val rowsA = a.size
            val colsA = a[0].size
            val colsB = b[0].size

            val result = Array(rowsA) { LongArray(colsB) { 0 } }

            for (i in 0..<rowsA) {
                for (k in 0..<colsA) {
                    for (j in 0..<colsB) {
                        result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % mod
                    }
                }
            }
            return result
        }

        fun identity(n: Int): Array<LongArray> {
            val id = Array(n) { LongArray(n) { 0 } }
            for (i in 0..<n) {
                id[i][i] = 1
            }
            return id
        }

        fun matrixPower(a: Array<LongArray>, p: Int): Array<LongArray> {
            if (p == 0) {
                return identity(a[0].size)
            }

            var r = matrixPower(a, p / 2)
            r = multiply(r, r)
            if (p % 2 == 1) {
                r = multiply(r, a)
            }
            return r
        }

        val freq = LongArray(26) { 0 }
        for (c in s) {
            freq[c.index()]++
        }

        val transformer = Array(26) { LongArray(26) { 0 } }
        for (c in 0..25) {
            for (x in 1..nums[c]) {
                transformer[c][(c + x) % 26]++
            }
        }

        val raisedTransformer = matrixPower(transformer, t)
        val initialFreqMatrix = Array(1) { freq }
        val finalFreqMatrix = multiply(initialFreqMatrix, raisedTransformer)

        var ans = 0L
        for (f in finalFreqMatrix[0]) {
            ans = (ans + f) % mod
        }
        return ans.toInt()
    }
}