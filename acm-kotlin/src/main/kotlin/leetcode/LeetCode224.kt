package leetcode

class LeetCode224 {
    private class Tokenizer(private val s: String) {
        private var i = 0

        fun nextToken(): String? {
            skipWhiteSpace()

            if (i >= s.length) {
                return null
            }

            if (s[i].isDigit()) {
                val sb = StringBuilder()
                while (i < s.length && s[i].isDigit()) {
                    sb.append(s[i])
                    i++
                }
                return sb.toString()
            } else {
                val token = "${s[i]}"
                i++
                return token
            }
        }

        private fun skipWhiteSpace() {
            while (i < s.length && s[i] == ' ')
                i++
        }
    }

    private fun getTokens(s: String): List<String> {
        val tokenizer = Tokenizer(s)
        val tokens = mutableListOf<String>()
        var token = tokenizer.nextToken()
        while (token != null) {
            tokens.add(token)
            token = tokenizer.nextToken()
        }
        return tokens
    }

    // X + Y - Z ..
    private fun calculateSimpleExpression(tokens: List<String>): String {
        var sign = 1
        var sum = 0
        for (token in tokens) {
            when (token) {
                "+" -> sign = 1
                "-" -> sign = -1
                else -> sum += sign * token.toInt()
            }
        }
        return sum.toString()
    }

    fun calculate(s: String): Int {
        val tokens = getTokens(s)
        val stack = mutableListOf<String>()
        for (token in tokens) {
            if (token == ")") {
                val subTokens = mutableListOf<String>()
                while (stack.last() != "(") {
                    subTokens.add(stack.removeLast())
                }
                stack.removeLast() // remove "("
                stack.add(calculateSimpleExpression(subTokens.reversed()))
            } else {
                stack.add(token)
            }
        }
        return calculateSimpleExpression(stack).toInt()
    }
}