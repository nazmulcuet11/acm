package leetcode

import java.util.*

class LeetCode1475 {
    fun finalPrices(prices: IntArray): IntArray {
        val ans = prices.copyOf()
        val stk = Stack<Int>()
        for (i in prices.indices) {
            while (stk.isNotEmpty() && prices[stk.last()] >= prices[i]) {
                val j = stk.pop()
                ans[j] = prices[j] - prices[i]
            }
            stk.add(i)
        }
        return ans
    }
}