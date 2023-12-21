package leetcode

class LeetCode93 {
    fun restoreIpAddresses(s: String): List<String> {
        val ans: MutableList<String> = mutableListOf()
        for (i in 1..s.length - 3) {
            for (j in i + 1 .. s.length - 2) {
                for (k in j + 1..<s.length) {
                    trySplitting(listOf(0, i, j, k, s.length), s)?.let {
                        ans.add(it)
                    }
                }
            }
        }
        return ans
    }

    private fun trySplitting(splitPoints: List<Int>, s: String): String? {
        val parts: MutableList<String> = mutableListOf()
        for (i in 1..<splitPoints.count()) {
            val part = s.substring(splitPoints[i - 1], splitPoints[i])
            if (!isValidPart(part)) {
                return null
            }
            parts.add(part)
        }
        return parts.joinToString(".")
    }

    private fun isValidPart(part: String): Boolean {
        if (part.isEmpty() || part.length > 3) {
            return false
        }

        if (part[0] == '0') {
            return part.length == 1
        }

        return part.toInt() < 256
    }
}