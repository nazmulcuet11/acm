package leetcode

import java.util.*

class LeetCode3170 {
    fun clearStars(s: String): String {
        fun Char.index() = code - 'a'.code
        val n = s.length
        val charToIndices = Array(26) { Stack<Int>() }
        val removed = BooleanArray(n) { false }
        for ((i, c) in s.withIndex()) {
            if (c == '*') {
                removed[i] = true
                for (x in 0..25) {
                    if (charToIndices[x].isNotEmpty()) {
                        val l = charToIndices[x].removeLast()
                        removed[l] = true
                        break
                    }
                }
            } else {
                charToIndices[c.index()].add(i)
            }
        }

        val sb = StringBuilder()
        for ((i, c) in s.withIndex()) {
            if (!removed[i]) {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}