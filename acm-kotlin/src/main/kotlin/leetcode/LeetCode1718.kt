package leetcode

class LeetCode1718 {
    private fun solve(
        i: Int,
        n: Int,
        ans: IntArray,
        taken: BooleanArray
    ): Boolean {
        if (i == ans.size) {
            return true
        }

        if (ans[i] != 0) {
            return solve(i + 1, n, ans, taken)
        }

        for (j in n downTo 1) {
            if (taken[j]) {
                continue
            }

            if (j == 1 || (i + j < ans.size && ans[i + j] == 0)) {
                taken[j] = true
                ans[i] = j
                if (j > 1) {
                    ans[i + j] = j
                }
                if (solve(i + 1, n, ans, taken)) {
                    return true
                }
                ans[i] = 0
                if (j > 1) {
                    ans[i + j] = 0
                }
                taken[j] = false
            }
        }
        return false
    }

    fun constructDistancedSequence(n: Int): IntArray {
        val ansSize = n * 2 - 1
        val ans = IntArray(ansSize) { 0 }
        val taken = BooleanArray(n + 1) { false }
        solve(0, n, ans, taken)
        return ans
    }
}