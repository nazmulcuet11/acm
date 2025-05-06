package leetcode

class LeetCode790 {
    fun numTilings(n: Int): Int {
        val mod = 1_000_000_000 + 7
        val cache = Array(n + 1) { IntArray(n + 1) { -1 } }

        fun solve(r1: Int, r2: Int): Int {
            if (r1 == 0 && r2 == 0) {
                return 1
            }

            if (r1 <= 0 || r2 <= 0) {
                return 0
            }

            if (cache[r1][r2] != -1) {
                return cache[r1][r2]
            }

            var ans = 0L
            if (r1 == r2) {
                // horizontal domino on both row
                ans += solve(r1 - 2, r2 - 2)
                // vertical domino
                ans += solve(r1 - 1, r2 - 1)
                // ↲ shape tromino
                ans += solve(r1 - 1, r2 - 2)
                // ↰ shape tromino
                ans += solve(r1 - 2, r2 - 1)
            } else if (r1 < r2) {
                // horizontal domino on row 2
                ans += solve(r1, r2 - 2)
                // ↳ shape tromino
                ans += solve(r1 - 1, r2 - 2)
            } else {
                // horizontal domino on row 1
                ans += solve(r1 - 2, r2)
                // ↱ shape tromino
                ans += solve(r1 - 2, r2 - 1)
            }

            cache[r1][r2] = (ans % mod).toInt()
            return cache[r1][r2]
        }

        return solve(n, n)
    }
}