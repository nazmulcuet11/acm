package leetcode

class LeetCode386 {
    private val comparator = Comparator<Int> { a, b ->
        if (a.toString() < b.toString()) {
            -1
        } else if (a.toString() > b.toString()) {
            1
        } else {
            0
        }
    }

    fun lexicalOrder(n: Int): List<Int> {
        return (1..n).toList().sortedWith(comparator)
    }
}