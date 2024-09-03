package leetcode

import kotlin.math.max

class LeetCode123 {
    data class Key(
        val today: Int,
        val bought: Boolean,
        val remainingTransaction: Int,
    )

    private var prices = intArrayOf()
    private var cache = mutableMapOf<Key, Int>()

    private fun solve(
        today: Int,
        bought: Boolean,
        remainingTransaction: Int,
    ): Int {
        if (today >= prices.size || remainingTransaction < 0) {
            return 0
        }

        val key = Key(today, bought, remainingTransaction)
        cache[key]?.let {
            return it
        }

        var ans = if (bought) {
            // sale
            solve(
                today + 1,
                false,
                remainingTransaction
            ) + prices[today]
        } else {
            // buy
            solve(
                today + 1,
                true,
                remainingTransaction - 1
            ) - prices[today]
        }

        // do nothing
        ans = max(
            ans,
            solve(
                today + 1,
                bought,
                remainingTransaction
            )
        )

        cache[key] = ans
        return ans
    }

    fun maxProfit(prices: IntArray): Int {
        this.prices = prices
        cache = mutableMapOf()
        return solve(0, false, 2)
    }
}