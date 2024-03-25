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

        return (i + 1..s.length)
            .flatMap { restoreIpAddresses(s, it, splitPoints + listOf(it)) }
    }

    private fun trySplitting(s: String, splitPoints: List<Int>): String? {
        val parts = (listOf(0) + splitPoints)
            .zip(splitPoints + listOf(s.length))
            .map { s.substring(it.first, it.second) }
            .filter { isValidPart(it) }

        return if (parts.count() == 4) parts.joinToString(".") else null
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