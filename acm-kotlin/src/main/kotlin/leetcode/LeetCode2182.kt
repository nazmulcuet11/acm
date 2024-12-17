package leetcode

class LeetCode2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val count = mutableMapOf<Char, Int>()
        for (c in s) {
            count[c] = count.getOrDefault(c, 0) + 1
        }
        val ans = StringBuilder()

        fun getCount(c: Char) = count.getOrDefault(c, 0)

        fun getNext(c: Char): Char? {
            for (n in Char(c.code - 1) downTo 'a') {
                if (getCount(n) > 0) {
                    return n
                }
            }
            return null
        }

        fun add(c: Char) {
            while (getCount(c) > 0) {
                for (i in 0..<repeatLimit) {
                    if (getCount(c) == 0) {
                        break
                    }
                    ans.append(c)
                    count[c] = getCount(c) - 1
                }

                if (getCount(c) > 0) {
                    val n = getNext(c)
                    if (n != null) {
                        ans.append(n)
                        count[n] = getCount(n) - 1
                    } else {
                        break
                    }
                }
            }
        }

        for (c in 'z' downTo 'a') {
            if (getCount(c) > 0) {
                add(c)
            }
        }

        return ans.toString()
    }
}