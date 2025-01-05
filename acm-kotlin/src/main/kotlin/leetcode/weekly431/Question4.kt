package leetcode.weekly431

import kotlin.math.min

class Question4 {
    private data class Interval(val start: Int, val end: Int)

    private data class Info(
        val index: Int,
        val interval: Interval,
        val weight: Int
    )

    private var infoList = listOf<Info>()
    private val indexToWeight = mutableMapOf<Int, Int>()
    private val cache = mutableMapOf<Pair<Int, Int>, List<Int>>()

    private fun isNonOverlapping(a: Interval, b: Interval): Boolean {
        return a.end < b.start || b.end < a.start
    }

    private fun next(i: Int): Int {
        for (j in i + 1..<infoList.size) {
            if (isNonOverlapping(infoList[i].interval, infoList[j].interval)) {
                return j
            }
        }
        return infoList.size
    }

    private fun score(l: List<Int>): Long {
        var score = 0L
        for (i in l) {
            score += indexToWeight.getOrDefault(i, 0)
        }
        return score
    }

    private fun minOfList(a: List<Int>, b: List<Int>): List<Int> {
        val sortedA = a.sorted()
        val sortedB = b.sorted()

        for (i in 0..<min(a.size, b.size)) {
            if (sortedA[i] < sortedB[i]) {
                return a
            } else if (sortedA[i] > sortedB[i]) {
                return b
            }
        }

        return if (a.size <= b.size) {
            a
        } else {
            b
        }
    }

    private fun solve(i: Int, c: Int): List<Int> {
        if (c >= 4) {
            return listOf()
        }
        if (i >= infoList.size) {
            return listOf()
        }

        val key = Pair(i, c)
        cache[key]?.let { return it }

        // skip i
        val a = solve(i + 1, c)
        val aScore = score(a)
        val b = solve(next(i), c + 1) + listOf(infoList[i].index)
        val bScore = score(b)

        val ans = if (aScore > bScore) {
            a
        } else if (bScore > aScore) {
            b
        } else {
            minOfList(a, b)
        }
        cache[key] = ans
        return ans
    }

    fun maximumWeight(intervals: List<List<Int>>): IntArray {
        val infoList = intervals.withIndex().map { Info(it.index, Interval(it.value[0], it.value[1]), it.value[2]) }
        this.infoList = infoList.sortedBy { it.interval.start }
        for (info in infoList) {
            indexToWeight[info.index] = info.weight
        }

        return solve(0, 0).sorted().toIntArray()
    }
}

fun main() {
    var ans = Question4().maximumWeight(
        listOf(listOf(1, 3, 2), listOf(4, 5, 2), listOf(1, 5, 5), listOf(6, 9, 3), listOf(6, 7, 1), listOf(8, 9, 1))
    )
    println(ans.toList())

    ans = Question4().maximumWeight(
        listOf(
            listOf(5, 8, 1),
            listOf(6, 7, 7),
            listOf(4, 7, 3),
            listOf(9, 10, 6),
            listOf(7, 8, 2),
            listOf(11, 14, 3),
            listOf(3, 5, 5)
        )
    )
    println(ans.toList())
}