package leetcode

class LeetCode1790 {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return  false
        }

        val differedIndices = mutableListOf<Int>()
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                differedIndices.add(i)
            }
        }

        if (differedIndices.isEmpty()) {
            return true
        }
        if (differedIndices.size != 2) {
            return false
        }

        val i = differedIndices[0]
        val j = differedIndices[1]
        return s1[i] == s2[j] && s2[i] == s1[j]
    }
}