package leetcode

import java.util.*

class LeetCode1792 {
    private data class Info(val pass: Int, val total: Int) {
        val ratio: Double
            get() = pass.toDouble() / total.toDouble()

        val nextRatio: Double
            get() = (pass + 1).toDouble() / (total + 1).toDouble()

        val ratioChange: Double
            get() = nextRatio - ratio
    }

    private val comparator = Comparator<Info> { a, b ->
        if (a.ratioChange > b.ratioChange) {
            -1
        } else if (a.ratioChange < b.ratioChange) {
            1
        } else {
            0
        }
    }

    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val pq = PriorityQueue<Info>(comparator)
        for (c in classes) {
            pq.add(Info(c[0], c[1]))
        }
        for (i in 0..<extraStudents) {
            val t = pq.poll()
            pq.add(Info(t.pass + 1, t.total + 1))
        }

        var totalRatio = 0.0
        while (pq.isNotEmpty()) {
            val t = pq.poll()
            totalRatio += t.ratio
        }

        return totalRatio / classes.count()
    }
}