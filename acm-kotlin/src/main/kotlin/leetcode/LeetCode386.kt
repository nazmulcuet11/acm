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

        if (c != 0) {
            ans.add(c)
        }

        for (i in 0..9) {
            if (c == 0 && i == 0) {
                continue
            }
            solve(c * 10 + i, n, ans)
        }
    }

    fun lexicalOrder(n: Int): List<Int> {
        val ans = mutableListOf<Int>()
        solve(0, n, ans)
        return ans
    }
}