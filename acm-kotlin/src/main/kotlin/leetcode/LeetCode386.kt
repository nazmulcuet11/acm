package leetcode

/*
//solution   1
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
*/

// solution 2
class LeetCode386 {
    private fun solve(c: Int, n: Int, ans: MutableList<Int>) {
        if (c > n) {
            return
        }
        ans.add(c)
        for (i in 0..9) {
            solve(c * 10 + i, n, ans)
        }
    }

    fun lexicalOrder(n: Int): List<Int> {
        val ans = mutableListOf<Int>()
        for (i in 1..9) {
            solve(i, n, ans)
        }
        return ans
    }
}