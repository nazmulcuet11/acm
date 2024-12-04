package leetcode

class LeetCode2825 {
    private fun next(a: Char): Char {
        if (a == 'z') return 'a'
        return Char(a.code + 1)
    }

    private fun match(a: Char, b: Char): Boolean {
        return a == b || next(a) == b
    }

    private fun isSubSequence(a: String, b: String, i: Int, j: Int): Boolean {
        if (j >= b.length) return true
        if (i >= a.length) return false

        return if (match(a[i], b[j])) {
            isSubSequence(a, b, i + 1, j + 1)
        } else {
            isSubSequence(a, b, i + 1, j)
        }
    }

    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        return isSubSequence(str1, str2, 0, 0)
    }
}
