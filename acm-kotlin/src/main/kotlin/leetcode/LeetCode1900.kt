package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode1900 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {

        fun Int.isBitSet(i: Int) = (this and (1 shl i)) > 0
        fun Int.setBit(i: Int) = this or (1 shl i)
        fun Int.clearBit(i: Int) = this and (1 shl i).inv()
        fun Int.getSetBits() = (0..<n).filter { isBitSet(it) }

        fun Int.isTerminal(): Boolean {
            val setBits = getSetBits()
            var i = 0
            var j = setBits.size - 1
            while (i < j) {
                if (setBits[i] == firstPlayer - 1 && setBits[j] == secondPlayer - 1) {
                    return true
                }
                i++
                j--
            }
            return false
        }

        val infinity = 100

        fun generateNewMasks(mask: Int): List<Int> {
            val setBits = mask.getSetBits()
            var newMasks = mutableListOf<Int>()
            var terminalFound = false
            fun generate(newMask: Int, i: Int, j: Int) {
                if (terminalFound) {
                    return
                }

                if (i >= j) {
                    if (newMask != mask) {
                        newMasks.add(newMask)
                    }
                    return
                }

                if (setBits[i] == firstPlayer - 1 && setBits[j] == secondPlayer - 1) {
                    if (newMask != mask) {
                        newMasks = mutableListOf(newMask)
                    }
                    terminalFound = true
                    return
                } else if (setBits[i] == firstPlayer - 1) {
                    generate(newMask.clearBit(setBits[j]), i + 1, j - 1)
                } else if (setBits[j] == secondPlayer - 1) {
                    generate(newMask.clearBit(setBits[i]), i + 1, j - 1)
                } else {
                    generate(newMask.clearBit(setBits[i]), i + 1, j - 1)
                    generate(newMask.clearBit(setBits[j]), i + 1, j - 1)
                }
            }

            generate(mask, 0, setBits.size - 1)
            return newMasks
        }

        val cache = mutableMapOf<Int, Int>()

        fun solve(mask: Int, minimize: Boolean): Int {
            cache[mask]?.let { return it }

            if (mask.isTerminal()) {
                return 1
            }

            val newMasks = generateNewMasks(mask)
            var ans = if (minimize) infinity else -infinity
            for (newMask in newMasks) {
                if (minimize) {
                    ans = min(ans, solve(newMask, minimize))
                } else {
                    ans = max(ans, solve(newMask, minimize))
                }
            }
            ans++
            cache[mask] = ans
            return ans
        }

        val newMasks = generateNewMasks(15)
        println(newMasks)

        var mask = 0
        (0..<n).forEach { mask = mask.setBit(it) }

        val mn = solve(mask, true)
        cache.clear()
        val mx = solve(mask, false)

        return intArrayOf(mn, mx)
    }
}