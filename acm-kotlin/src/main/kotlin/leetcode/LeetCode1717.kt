package leetcode

import java.util.Stack

class LeetCode1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var ans = 0
        fun removeSub(str: String, sub: String, point: Int): String {
            val stack = Stack<Char>()
            for (c in str) {
                if (c == sub[1] && stack.isNotEmpty() && stack.peek() == sub[0]) {
                    stack.pop()
                    ans += point
                } else {
                    stack.push(c)
                }
            }
            return stack.joinToString("")
        }


        if (x > y) {
            removeSub(removeSub(s, "ab", x), "ba", y)
        } else {
            removeSub(removeSub(s, "ba", y), "ab", x)
        }

        return ans
    }
}