package leetcode

import kotlin.math.max

class LeetCode3003 {
    fun maxPartitionsAfterOperations(s: String, k: Int): Int {
        fun Char.index() = code - 'a'.code
        fun Int.isBitSet(i: Int) = (this and (1 shl i)) > 0
        fun Int.setBit(i: Int) = this or (1 shl i)
        fun Int.bitCount(): Int {
            var count = 0
            for (c in 'a'..'z') {
                if (isBitSet(c.index())) count++
            }
            return count
        }

        fun makeKey(i: Int, r: Int, mask: Int): Long {
            return (i.toLong() shl 27) or (r.toLong() shl 26) or mask.toLong()
        }

        val n = s.length
        val cache = mutableMapOf<Long, Int>()
        fun solve(i: Int, r: Int, mask: Int): Int {

            fun nextCall(r: Int, c: Char): Int {
                val newMask = mask.setBit(c.index())
                return if (newMask.bitCount() > k) {
                    solve(i + 1, r, 0.setBit(c.index())) + 1
                } else {
                    solve(i + 1, r, newMask)
                }
            }

            if (i == n) return 1

            val key = makeKey(i, r, mask)
            cache[key]?.let { return it }

            var ans = nextCall(r, s[i])
            if (r > 0) {
                for (c in 'a'..'z') {
                    ans = max(ans, nextCall(r - 1, c))
                }
            }

            cache[key] = ans
            return ans
        }

        return solve(0, 1, 0)
    }
}