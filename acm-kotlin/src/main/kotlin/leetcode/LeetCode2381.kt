package leetcode

class LeetCode2381 {
    private fun next(c: Char, count: Int): Char {
        val offset = ((count % 26) + 26) % 26
        return Char('a'.code + ((c.code - 'a'.code) + offset) % 26)
    }

    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val ops = IntArray(s.length + 1) { 0 }
        for (shift in shifts) {
            if (shift[2] == 1) {
                ops[shift[0]] += 1
                ops[shift[1] + 1] -= 1
            } else {
                ops[shift[0]] -= 1
                ops[shift[1] + 1] += 1
            }
        }

        for (i in 1..<ops.size) {
            ops[i] += ops[i - 1]
        }

        val chars = s.toCharArray()
        for ((i, c) in chars.withIndex()) {
            chars[i] = next(c, ops[i])
        }
        return chars.concatToString()
    }
}