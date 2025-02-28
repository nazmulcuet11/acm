package leetcode

class LeetCode1092 {
    private data class Index(val i: Int, val j: Int)

    private val next = mutableMapOf<Index, Index>()
    private val cache = mutableMapOf<Index, Int>()

    private fun lcs(a: String, b: String, i: Int, j: Int): Int {
        if (i >= a.length || j >= b.length) {
            return 0
        }

        val index = Index(i, j)
        cache[index]?.let { return it }

        if (a[i] == b[j]) {
            val x = lcs(a, b, i + 1, j + 1) + 1
            next[index] = Index(i + 1, j + 1)
            cache[index] = x
            return x
        } else {
            val x = lcs(a, b, i + 1, j)
            val y = lcs(a, b, i, j + 1)
            if (x >= y) {
                next[index] = Index(i + 1, j)
                cache[index] = x
                return x
            } else {
                next[index] = Index(i, j + 1)
                cache[index] = y
                return y
            }
        }
    }

    private fun getLCSPath(a: String, b: String): List<Index> {
        lcs(a, b, 0, 0)

        val path = mutableListOf<Index>()
        var index: Index? = Index(0, 0)
        while (index != null) {
            if (index.i < a.length && index.j < b.length && a[index.i] == b[index.j]) {
                path.add(index)
            }
            index = next[index]
        }
        return path
    }

    private fun buildSuperSequence(a: String, b: String): String {
        val path = getLCSPath(a, b)

        val sb = StringBuilder()
        var i = 0
        var j = 0
        for (p in path) {
            while (i < p.i) {
                sb.append(a[i])
                i++
            }

            while (j < p.j) {
                sb.append(b[j])
                j++
            }

            sb.append(a[p.i])
            i = p.i + 1
            j = p.j + 1
        }

        while (i < a.length) {
            sb.append(a[i])
            i++
        }

        while (j < b.length) {
            sb.append(b[j])
            j++
        }

        return sb.toString()
    }

    fun shortestCommonSupersequence(str1: String, str2: String): String {
        return buildSuperSequence(str1, str2)
    }
}