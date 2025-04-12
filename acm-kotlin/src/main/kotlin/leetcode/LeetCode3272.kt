package leetcode

class LeetCode3272 {
    fun countGoodIntegers(n: Int, k: Int): Long {
        fun String.sorted() = toCharArray().sorted().joinToString("")
        fun String.isDivisible() = toLong() % k == 0L

        val goodNumbers = mutableSetOf<String>()
        fun generate(i: Int, sb: StringBuilder) {
            if (i > n / 2) {
                val s = sb.toString()
                if (s.isDivisible() && !goodNumbers.contains(s.sorted())) {
                    goodNumbers.add(s.sorted())
                }
                return
            }

            val start = if (i == 0) '1' else '0'
            for (c in start..'9') {
                sb[i] = c
                sb[n - 1 - i] = c
                generate(i + 1, sb)
            }
        }

        val sb = StringBuilder()
        for (i in 0..<n) {
            sb.append('_')
        }
        generate(0, sb)

        val factorial = LongArray(11) { 0 }
        factorial[0] = 1
        for (i in 1..10) {
            factorial[i] = factorial[i - 1] * i
        }

        fun getFrequency(s: String): IntArray {
            val frequency = IntArray(10) { 0 }
            for (c in s) {
                frequency[c.digitToInt()]++
            }
            return frequency
        }

        fun countPermutations(frequency: IntArray): Long {
            val sum = frequency.sum()
            var total = factorial[sum]
            for (d in 0..9) {
                total /= factorial[frequency[d]]
            }
            return total
        }

        fun countPermutations(s: String): Long {
            val frequency = getFrequency(s)
            val total = countPermutations(frequency)
            var invalid = 0L
            if (frequency[0] > 0) {
                frequency[0]--
                invalid = countPermutations(frequency)
            }
            return total - invalid
        }

        var count = 0L
        for (goodNumber in goodNumbers) {
            count += countPermutations(goodNumber)
        }
        return count
    }
}