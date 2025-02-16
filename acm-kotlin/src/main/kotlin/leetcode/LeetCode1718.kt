package leetcode

class LeetCode1718 {
    private var ans = IntArray(0)

    private fun compareAndUpdateAns(current: IntArray) {
        for (i in current.indices) {
            if (current[i] < ans[i]) {
                return
            } else if (current[i] > ans[i]) {
                ans = current.copyOf()
                return
            }
        }
    }

    private fun solve(
        i: Int,
        n: Int,
        current: IntArray,
        taken: BooleanArray,
        remaining: Int
    ): Boolean {
        if (remaining == 0) {
            compareAndUpdateAns(current)
            return true
        }

        if (i == current.size) {
            // invalid
            return false
        }

        if (current[i] != 0) {
            return solve(i + 1, n, current, taken, remaining)
        }

        for (j in n downTo 1) {
            if (taken[j]) {
                continue
            }

            if (j == 1) {
                taken[j] = true
                current[i] = j
                if (solve(i + 1, n, current, taken, remaining - 1)) {
                    return true
                }
                current[i] = 0
                taken[j] = false
            } else if (i + j < current.size && current[i + j] == 0) {
                taken[j] = true
                current[i] = j
                current[i + j] = j
                if (solve(i + 1, n, current, taken, remaining - 1)) {
                    return true
                }
                current[i] = 0
                current[i + j] = 0
                taken[j] = false
            }
        }
        return false
    }

    fun constructDistancedSequence(n: Int): IntArray {
        val ansSize = n * 2 - 1
        ans = IntArray(ansSize) { 0 }
        val current = IntArray(ansSize) { 0 }
        val taken = BooleanArray(n + 1) { false }
        solve(0, n, current, taken, n)
        return ans
    }
}