package leetcode

import java.util.*
import kotlin.math.floor
import kotlin.math.sqrt

class LeetCode2558 {
    private val comparator = Comparator<Int> { a,b -> b - a }

    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(comparator)
        for (g in gifts) {
            pq.add(g)
        }

        for (i in 0..<k) {
            if (pq.isEmpty()) {
                break
            }

            val t = pq.poll()
            val r = floor(sqrt(t.toDouble())).toInt()
            if (r != 0) {
                pq.add(r)
            }
        }

        var sum = 0L
        while (pq.isNotEmpty()) {
            sum += pq.poll()
        }
        return sum
    }
}