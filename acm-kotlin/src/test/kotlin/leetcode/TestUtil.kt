package leetcode

fun<T: Comparable<T>> sorted(list: List<List<T>>): List<List<T>> {
    return list
        .map { it.sorted() }
        .sortedWith(ListComparator())
}

class ListComparator<T: Comparable<T>>: Comparator<List<T>> {
    override fun compare(lhs: List<T>, rhs: List<T>): Int {
        var i = 0
        var j = 0
        while (i < lhs.count() && j <  rhs.count()) {
            if (lhs[i] < rhs[j]) return -1
            if (lhs[i] > rhs[j]) return 1
            i++
            j++
        }

        if (i < lhs.count()) return 1
        if (j <  rhs.count()) return -1
        return 0
    }
}