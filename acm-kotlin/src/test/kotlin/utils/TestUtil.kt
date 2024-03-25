package utils

import kotlin.math.min

fun<T: Comparable<T>> sorted(list: List<List<T>>): List<List<T>> {
    return list
        .map { it.sorted() }
        .sortedWith(ListComparator())
}

class ListComparator<T: Comparable<T>>: Comparator<List<T>> {
    override fun compare(lhs: List<T>, rhs: List<T>): Int {
        for (i in 0..<min(lhs.count(), rhs.count())) {
            if (lhs[i] < rhs[i]) return -1
            if (lhs[i] > rhs[i]) return 1
        }

        if (lhs.count() < rhs.count()) return -1
        if (lhs.count() > rhs.count()) return 1
        return 0
    }
}