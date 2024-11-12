package leetcode

import kotlin.math.max

class LeetCode2070 {
    private data class Item(val price: Int, val beauty: Int)

    private var sortedItems = listOf<Item>()
    private val maxBeauties = mutableListOf<Int>()

    private val comp = Comparator<Item> { a, b ->
        return@Comparator if (a.price < b.price) {
            -1
        } else if (a.price > b.price) {
            1
        } else {
            0
        }
    }

    private fun maxBeauty(maxPrice: Int): Int {
        var l = 0
        var h = sortedItems.size - 1
        while (l < h) {
            val m = (l + h + 1) / 2
            if (sortedItems[m].price > maxPrice) {
                h = m - 1
            } else {
                l = m
            }
        }

        return if (l < sortedItems.size && sortedItems[l].price <= maxPrice) {
            maxBeauties[l]
        } else {
            0
        }
    }

    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        sortedItems = items.map { Item(it[0], it[1]) }.sortedWith(comp)
        for (item in sortedItems) {
            if (maxBeauties.isEmpty()) {
                maxBeauties.add(item.beauty)
            } else {
                maxBeauties.add(max(maxBeauties.last(), item.beauty))
            }
        }

        val ans = mutableListOf<Int>()
        for (q in queries) {
            ans.add(maxBeauty(q))
        }
        return ans.toIntArray()
    }
}