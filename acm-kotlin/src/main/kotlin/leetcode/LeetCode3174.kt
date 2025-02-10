package leetcode

import java.util.*

class LeetCode3174 {
    fun clearDigits(s: String): String {
        val stack = Stack<Char>()
        for (c in s) {
            if (c.isDigit()) {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            } else {
                stack.add(c)
            }
        }
        return stack.joinToString(separator = "")
    }
}