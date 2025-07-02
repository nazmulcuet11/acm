package leetcode

import jdk.nashorn.internal.objects.NativeFunction.function
import sun.util.calendar.CalendarUtils.mod
import java.util.Collections.frequency
import kotlin.math.max
import kotlin.math.min

class LeetCode3333 {
    fun possibleStringCount(word: String, k: Int): Int {
        val mod = (1e9 + 7).toLong()

        var total = 1L
        val frequencies = mutableListOf<Int>()
        var i = 0
        while (i < word.length) {
            var frequency = 1
            while (i + 1 < word.length && word[i + 1] == word[i]) {
                i++
                frequency++
            }
            frequencies.add(frequency)
            total = (total * frequency) % mod
            i++
        }

        val maxI = min(frequencies.size, k)
        val maxL = k - 1

        val cache = Array(maxI + 1) { LongArray(maxL + 1) { -1 } }

        /*
        // count no of ways to build a string of length <= l
        fun count(i: Int, l: Int): Long {
            if (l == 0) {
                return if (i == 0) 1 else 0
            }

            if (i == 0) {
                return 1
            }

            if (cache[i][l] != -1L) {
                return cache[i][l]
            }

            val maxX = min(l, frequencies[i - 1])
            var ans = 0L
            for (x in 1..maxX) {
                val c = count(i - 1, l - x)
                ans = (ans + c) % mod
            }
            cache[i][l] = ans
            return ans
        }
        */

        // The above recursive code can be changed to the following iterative one

        cache[0][0] = 1
        for (i in 1..maxI) {
            cache[i][0] = 0
        }

        for (l in 1..maxL) {
            cache[0][l] = 1
        }

        for (i in 1..maxI) {
            for (l in 1..maxL) {
                /*
                val maxX = min(l, frequencies[i - 1])
                var ans = 0L
                for (x in 1..maxX) {
                    ans = (ans + cache[i - 1][l - x]) % mod
                }
                cache[i][l] = ans
                 */

                // This can be changed to the following
                /*
                val maxX = min(l, frequencies[i - 1])
                var ans = 0L
                for (x in maxX downTo 1) {
                    ans = (ans + cache[i - 1][l - x]) % mod
                }
                cache[i][l] = ans
                 */

                // This can be changed to the following
                /*
                val maxX = min(l, frequencies[i - 1])
                val left = l - maxX
                val right = l - 1
                var ans = 0L
                for (t in left..right) {
                    ans = (ans + cache[i - 1][t]) % mod
                }
                cache[i][l] = ans
                */

                // This can be changed to the following
                val maxX = min(l, frequencies[i - 1])
                val right = l - 1
                val left = l - maxX
                var ans = cache[i - 1][right]
                if (left > 0) {
                    ans = (ans - cache[i - 1][left - 1]) % mod
                }
                cache[i][l] = ans
                // keep cumulative sum
                cache[i][l] = (cache[i][l - 1] + cache[i][l]) % mod
            }
        }

//        val invalid = count(maxI, maxL)
        val invalid = cache[maxI][maxL]
        val ans = (total - invalid + mod) % mod
        return ans.toInt()
    }
}