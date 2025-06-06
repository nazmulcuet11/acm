package leetcode

import java.util.*

class LeetCode2434 {
    fun robotWithString(s: String): String {
        fun min(a: Char, b: Char) = if (a.code <= b.code) a else b

        val n = s.length
        val minChar = CharArray(n) { s[it] }
        for (i in n - 2 downTo 0) {
            minChar[i] = min(minChar[i], minChar[i + 1])
        }

        val sb = StringBuilder()
        val stack = Stack<Char>()
        for (i in 0..<n) {
            while (stack.isNotEmpty() && stack.peek() <= minChar[i]) {
                sb.append(stack.pop())
            }
            stack.add(s[i])
        }

        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }

        return sb.toString()
    }
}