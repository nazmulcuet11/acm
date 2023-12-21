package leetcode

class LeetCode93 {
    fun restoreIpAddresses(s: String): List<String> {
        return restoreIpAddresses(s, 0, listOf())
    }

    private fun restoreIpAddresses(
        s: String,
        i: Int,
        splitPoints: List<Int>
    ): List<String> {
        if (splitPoints.count() == 3) {
            return trySplitting(s, splitPoints)?.let { listOf(it) } ?: listOf()
        }

        val ans: MutableList<String> = mutableListOf()
        for (j in i + 1..<s.length) {
            ans += restoreIpAddresses(s, j, splitPoints + listOf(j))
        }
        return ans
    }

    private fun trySplitting(s: String, splitPoints: List<Int>): String? {
        val parts: MutableList<String> = mutableListOf()
        @Suppress("NAME_SHADOWING")
        val splitPoints = listOf(0) + splitPoints + listOf(s.length)
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