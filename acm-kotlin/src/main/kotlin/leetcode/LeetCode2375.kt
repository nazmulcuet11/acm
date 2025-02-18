package leetcode

class LeetCode2375 {

    private fun Char.next() = Char(code + 1)

    private fun solve(
        i: Int,
        pattern: String,
        taken: MutableMap<Char, Boolean>,
        current: StringBuilder
    ): Boolean {
        if (i == pattern.length) {
            return true
        }

        if (pattern[i] == 'I') {
            for (c in current.last().next()  ..'9') {
                if (taken[c] == true) {
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
        } else {
            for (c in '1'..<current.last()) {
                if (taken[c] == true) {
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