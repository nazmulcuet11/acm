package leetcode

class LeetCode2064 {
    private fun validate(
        quantities: IntArray,
        numberOfStores: Int,
        maxProductPerStore: Int
    ): Boolean {
        var i = 0
        var j = 0
        while (i < quantities.size && j < numberOfStores) {
            if (quantities[i] > maxProductPerStore) {
                quantities[i] -= maxProductPerStore
            } else {
                quantities[i] = 0
                i++
            }
            j++
        }
        return i == quantities.size
    }

    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var l = 0
        var h = 100000 + 5
        while (l <= h) {
            val m = l + (h - l) / 2
            if (validate(quantities.copyOf(), n, m)) {
                h = m - 1
            } else {
                l = m + 1
            }
        }
        return l
    }
}