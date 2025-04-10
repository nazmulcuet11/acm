package leetcode

class LeetCode2999 {
    fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
        var cache = Array(16) { LongArray(2) { -1 } }

        /*
        * counts number of integer from 0 to n using digits from 0 to limit
        */
        fun count(i: Int, tight: Int, n: String): Long {
            if (i == n.length) {
                return 1
            }

            if (cache[i][tight] != -1L) {
                return cache[i][tight]
            }

            cache[i][tight] = if (tight == 1 && n[i].digitToInt() <= limit) {
                n[i].digitToInt() * count(i + 1, 0, n) + count(i + 1, 1, n)
            } else {
                (limit + 1) * count(i + 1, 0, n)
            }
            return cache[i][tight]
        }

        fun subtract(prefix: String, suffix: String): Boolean {
            if (suffix >= s) {
                return false
            }

            for (c in prefix) {
                if (c.digitToInt() > limit) {
                    return false
                }
            }
            return true
        }

        /*
        * counts number of integer from 1 to n using digits from 0 to limit and with suffix s
        */
        fun count(n: String): Long {
            if (n.length < s.length) {
                return 0
            }
            if (n.length == s.length) {
                return if (n >= s) 1 else 0
            }

            val prefix = n.substring(0, n.length - s.length)
            val suffix = n.substring(n.length - s.length)
            cache = Array(16) { LongArray(2) { -1 } }
            var result = count(0, 1, prefix)
            if (subtract(prefix, suffix)) {
                result--
            }
            return result
        }

        fun count(n: Long) = count(n.toString())

        return count(finish) - count(start - 1)
    }
}