package leetcode

class LeetCode1931 {
    fun colorTheGrid(m: Int, n: Int): Int {
        val variations = mutableListOf<List<Int>>()
        variations.add(List(m) { -1 })

        fun generate(variation: List<Int>) {
            if (variation.size == m) {
                variations.add(variation)
                return
            }

            val last = if (variation.isEmpty()) -1 else variation.last()
            for (color in 0..2) {
                if (color != last) {
                    generate(variation + color)
                }
            }
        }

        generate(listOf())

        val csnCache = Array(variations.size) { IntArray(variations.size) { -1 } }
        fun canSitNext(i: Int, j: Int): Boolean {
            val cachedResult = csnCache[i][j]
            if (cachedResult == 0) {
                return false
            }
            if (cachedResult == 1) {
                return true
            }

            val a = variations[i]
            val b = variations[j]
            for (k in a.indices) {
                if (a[k] == b[k]) {
                    csnCache[i][j] = 0
                    return false
                }
            }
            csnCache[i][j] = 1
            return true
        }

        val mod = (1e9 + 7).toInt()

        val cache = Array(n) { LongArray(variations.size) { -1 } }
        fun solve(i: Int, prev: Int): Long {
            if (i == n) {
                return 1
            }

            if (cache[i][prev] != -1L) {
                return cache[i][prev]
            }

            var ans = 0L
            for (new in 1..<variations.size) {
                if (canSitNext(prev, new)) {
                    ans = (ans + solve(i + 1, new)) % mod
                }
            }
            cache[i][prev] = ans
            return ans
        }

        return solve(0, 0).toInt()
    }
}