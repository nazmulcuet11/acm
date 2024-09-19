package leetcode

class LeetCode241 {
    private fun String.isNumber(): Boolean {
        for (c in this) {
            if (!c.isDigit()) {
                return false
            }
        }
        return true
    }

    private fun compute(a: Int, b: Int, op: Char): Int {
        return when (op) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            else -> error("invalid operation")
        }
    }

    private fun combine(l: List<Int>, r: List<Int>, op: Char): List<Int> {
        val combined = mutableListOf<Int>()
        for (a in l) {
            for (b in r) {
                combined.add(compute(a, b, op))
            }
        }
        return combined
    }

    fun diffWaysToCompute(expression: String): List<Int> {
        if (expression.isNumber()) {
            return listOf(expression.toInt())
        }

        val ans = mutableListOf<Int>()
        for ((i, c) in expression.withIndex()) {
            if (!c.isDigit()) {
                val l = diffWaysToCompute(expression.substring(0, i))
                val r = diffWaysToCompute(expression.substring(i+1, expression.length))
                ans += combine(l, r, c)
            }
        }
        return ans
    }
}