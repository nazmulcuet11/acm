package leetcode.weekly433

class Question2 {
    private companion object {
        const val MOD: Long = 1000_000_000 + 7
    }

    private var ncr = Array(0) { longArrayOf() }

    private fun computeNCR(maxN: Int, maxR: Int) {
        ncr[0][0] = 1
        for (n in 1..maxN) {
            ncr[n][0] = 1
            for (r in 1..maxR) {
                ncr[n][r] = (ncr[n - 1][r - 1] + ncr[n - 1][r]) % MOD
            }
        }
    }

    fun minMaxSums(nums: IntArray, k: Int): Int {
        this.ncr = Array(nums.size + 1) { LongArray(k + 1) { 0 } }
        computeNCR(nums.size, k)
        nums.sort()
        var ans = 0L
        for (x in 1..k) {
            for (i in nums.indices) {
                val t = (nums[i] * ncr[nums.size - 1 - i][x - 1]) % MOD
                ans = (ans + t) % MOD
            }

            for (i in nums.indices.reversed()) {
                val t = (nums[i] * ncr[i][x - 1]) % MOD
                ans = (ans + t) % MOD
            }
        }

        return ans.toInt()
    }
}