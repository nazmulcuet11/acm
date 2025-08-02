package leetcode

class LeetCode2561 {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        fun computeFreq(basket: IntArray, freq: MutableMap<Int, Int>) {
            for (n in basket) {
                freq[n] = freq.getOrDefault(n, 0) + 1
            }
        }

        val extra = mutableListOf<Int>()

        fun put(k: Int, count: Int) {
            for (x in 0..<count) {
                extra.add(k)
            }
        }

        val freq1 = mutableMapOf<Int, Int>()
        val freq2 = mutableMapOf<Int, Int>()

        computeFreq(basket1, freq1)
        computeFreq(basket2, freq2)

        val allKeys = basket1.toSet() + basket2.toSet()

        for (k in allKeys) {
            val f1 = freq1.getOrDefault(k, 0)
            val f2 = freq2.getOrDefault(k, 0)
            val total = f1 + f2
            if (total % 2 == 1) {
                return -1
            }

            val average = total / 2

            if (f1 > average) {
                put(k, f1 - average)
            }

            if (f2 > average) {
                put(k, f2 - average)
            }
        }

        extra.sort()

        val mn = allKeys.min()
        var i = 0
        var j = extra.size - 1
        var cost = 0L

        while (i < j && extra[i] <= 2 * mn) {
            cost += extra[i]
            i++
            j--
        }

        cost += (j - i + 1) * mn

        return cost
    }
}


