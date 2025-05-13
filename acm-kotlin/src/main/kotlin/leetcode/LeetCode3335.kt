package leetcode

/*
class LeetCode3335 {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        val mod = 1_000_000_000 + 7

        fun Char.index() = this.code - 'a'.code

        val count = LongArray(26) { 0 }
        for (c in s) {
            count[c.index()]++
        }

        for (i in 0..<t) {
            val zCount = count[25]

            for (c in 'y' downTo 'a') {
                count[c.index() + 1] = count[c.index()]
                count[c.index()] = 0
            }

            count[0] = (count[0] + zCount) % mod
            count[1] = (count[1] + zCount) % mod
        }

        var ans = 0L
        for (n in count) {
            ans = (ans + n) % mod
        }
        return ans.toInt()
    }
}
*/

class LeetCode3335 {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        val mod = 1_000_000_000 + 7

        fun Char.index() = this.code - 'a'.code

        val count = IntArray(26) { 0 }
        for (c in s) {
            count[c.index()]++
        }

        val cache = Array(t + 1) { IntArray(26) { -1 } }
        // solve(i: Int, c: Int) returns the number of character c after i transformation
        fun solve(i: Int, c: Int): Int {
            if (i == 0) {
                // no transformation
                return count[c]
            }

            if (cache[i][c] != -1) {
                return cache[i][c]
            }

            val result = when (c) {
                0 -> {
                    // c = 0('a') can come from c = 25('b')
                    solve(i - 1, 25)
                }
                1 -> {
                    // c = 0('a') can come from c = 25('b') and c = 0('a')
                    (solve(i - 1, 25) + solve(i - 1, 0)) % mod
                }
                else -> {
                    // c can come from c - 1
                    solve(i - 1, c - 1)
                }
            }

            cache[i][c] = result
            return result
        }

        var ans = 0
        for (c in 0..<26) {
            ans = (ans + solve(t, c)) % mod
        }
        return ans
    }
}