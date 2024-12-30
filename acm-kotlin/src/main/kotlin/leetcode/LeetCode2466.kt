package leetcode

class LeetCode2466 {
    private companion object {
        const val MOD = 1000_000_000 + 7
    }

    private var low: Int = 0
    private var high: Int = 0
    private var zero: Int = 0
    private var one: Int = 0
    private val cache = mutableMapOf<Int, Int>()

    private fun solve(len: Int): Int {
        if (len > high) {
            return 0
        }

        cache[len]?.let {
            return it
        }

        var ans = if (len >= low) 1 else 0
        ans = (ans + solve(len + zero) % MOD) % MOD
        ans = (ans + solve(len + one) % MOD) % MOD
        cache[len] = ans
        return  ans
    }

    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        this.low = low
        this.high = high
        this.zero = zero
        this.one = one

        return solve(0)
    }
}