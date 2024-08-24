package leetcode

import java.util.*
//
//fun <E> MutableList<E>.swap(i: Int, j: Int) {
//    val t = this[i]
//    this[i] = this[j]
//    this[j] = t
//}
//
//class Heap<E: Comparable<E>> {
//    private var elements = mutableListOf<E>()
//
//    val size: Int
//        get() = elements.size
//
//    val isEmpty: Boolean
//        get() = size == 0
//
//    fun top(): E? = elements.firstOrNull()
//
//    fun push(e: E) {
//        elements.add(e)
//        swim(size - 1)
//    }
//
//    fun pop(): E? {
//        if (isEmpty) {
//            return null
//        }
//
//        elements.swap(0, size - 1)
//        val last = elements.removeLast()
//        if (isEmpty.not()) {
//            dive(0)
//        }
//        return last
//    }
//
//    private fun dive(i: Int) {
//        var m = i
//        val c1 = i * 2 + 1
//        val c2 = i * 2 + 2
//        if (c1 < size && elements[c1] > elements[m]) {
//            m = c1
//        }
//
//        if (c2 < size && elements[c2] > elements[m]) {
//            m = c2
//        }
//
//        if (m != i) {
//            elements.swap(i, m)
//            dive(m)
//        }
//    }
//
//    private fun swim(i: Int) {
//        if (i == 0) {
//            return
//        }
//
//        val p = (i - 1) / 2
//        if (elements[p] < elements[i]) {
//            elements.swap(i, p)
//            swim(p)
//        }
//    }
//}

data class Project (
    val capital: Int,
    val profit: Int,
): Comparable<Project> {
    override fun compareTo(other: Project): Int {
        return if (this.profit < other.profit) {
            1
        } else if (this.profit > other.profit) {
            -1
        } else {
            0
        }
    }
}

class LeetCode502 {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val projects = mutableListOf<Project>()
        for (i in profits.indices) {
            projects.add(
                Project(capital[i], profits[i])
            )
        }

        projects.sortBy { it.capital }

        val heap = PriorityQueue<Project>()
        var totalCapital = w
        var i = 0
        for (x in 0..<k) {
            while (i < projects.size && projects[i].capital <= totalCapital) {
                heap.add(projects[i])
                i++
            }

            if (heap.isNotEmpty()) {
                totalCapital += heap.poll().profit
            }
        }
        return totalCapital
    }
}