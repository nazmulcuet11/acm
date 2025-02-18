package leetcode

class LeetCode2375 {
    private fun solve(
        i: Int,
        pattern: String,
        taken: MutableMap<Char, Boolean>,
        current: StringBuilder
    ): Boolean {
        if (i == pattern.length) {
            return true
        }

        for (c in '1'..'9') {
            if (taken[c] == true) {
                continue
            }

            if (pattern[i] == 'I' && c <= current.last()) {
                continue
            }

            if (pattern[i] == 'D' && c >= current.last()) {
                continue
            }

            current.append(c)
            taken[c] = true
            if (solve(i + 1, pattern, taken, current)) {
                return true
            }
            current.setLength(current.length - 1)
            taken[c] = false
        }
        return false
    }

    fun smallestNumber(pattern: String): String {
        for (c in '1'..'9') {
            val sb = StringBuilder()
            sb.append(c)
            val taken = mutableMapOf<Char, Boolean>()
            taken[c] = true
            if (solve(0, pattern, taken, sb)) {
                return sb.toString()
            }
        }
        return "INVALID"
    }
}