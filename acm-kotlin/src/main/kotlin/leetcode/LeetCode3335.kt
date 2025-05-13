package leetcode

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