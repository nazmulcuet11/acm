package leetcode

class LeetCode2116 {
    fun canBeValid(s: String, locked: String): Boolean {
        if (s.length % 2 == 1) {
            return false
        }

        var opening = 0
        var closing = 0
        var wildcard = 0

        fun updateCount(i: Int) {
            if (locked[i] == '0') {
                wildcard++
            } else {
                if (s[i] == '(') {
                    opening++
                } else {
                    closing++
                }
            }
        }

        for (i in s.indices) {
            updateCount(i)
            if (opening + wildcard < closing) {
                return false
            }
        }

        opening = 0
        closing = 0
        wildcard = 0
        for (i in s.indices.reversed()) {
            updateCount(i)
            if (closing + wildcard < opening) {
                return false
            }
        }

        return true
    }
}

