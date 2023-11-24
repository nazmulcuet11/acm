package leetcode

class Solution1561 {
    fun maxCoins(piles: IntArray): Int {
        return piles
            .sortedDescending()
            .filterIndexed { i, _ -> i % 2 == 1 }
            .take(piles.count() / 3)
            .sum()
    }
}