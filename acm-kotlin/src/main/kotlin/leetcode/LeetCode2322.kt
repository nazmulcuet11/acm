package leetcode

import kotlin.math.min

class LeetCode2322 {
    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {

        val tree = Array(nums.size) { mutableSetOf<Int>() }
        for (edge in edges) {
            tree[edge[0]].add(edge[1])
            tree[edge[1]].add(edge[0])
        }

        var totalXor = 0L
        for (n in nums) {
            totalXor = totalXor xor n.toLong()
        }

        var ans = Long.MAX_VALUE

        fun updateAns(xorOne: Long, xorTwo: Long, xorThree: Long) {
            val mx = maxOf(xorOne, xorTwo, xorThree)
            val mn = minOf(xorOne, xorTwo, xorThree)
            // println("updateAns: mx: $mx, mn: $mn")
            ans = min(ans, mx - mn)
        }

        fun runReverseDfs(
            start: Int,
            notAllowed: Int,
            xorOne: Long
        ) {
            // println("runReverseDfs: start: $start, notAllowed: $notAllowed, xorOne: $xorOne")

            val xorTwoAndThree = totalXor xor xorOne

            val visited = mutableMapOf<Int, Boolean>()
            fun dfs(i: Int): Long {
                visited[i] = true
                var xorTwo = nums[i].toLong()
                for (j in tree[i]) {
                    if (!visited.getOrDefault(j, false) && j != notAllowed) {
                        val subTotal = dfs(j)
                        xorTwo = xorTwo xor subTotal
                    }
                }

                if (i != start) {
                    val xorThree = xorTwoAndThree xor xorTwo
                    // println("Split at: $i, xorOne: $xorOne, xorTwo: $xorTwo, xorThree: $xorThree")
                    updateAns(xorOne, xorTwo, xorThree)
                }

                return xorTwo
            }

            dfs(start)
        }


        data class Info(val xorOne: Long, val subTreeSize: Int)
        val visited = mutableMapOf<Int, Boolean>()
        fun dfs(i: Int, parent: Int): Info {
            visited[i] = true
            var xorOne = nums[i].toLong()
            var treeSize = 1
            for (j in tree[i]) {
                if (!visited.getOrDefault(j, false)) {
                    val (subTotal, subTreeSize) = dfs(j, i)
                    xorOne = xorOne xor subTotal
                    treeSize += subTreeSize
                }
            }
            // println("Node: $i, xorOne: $xorOne, treeSize: $treeSize")
            if (parent != -1 && nums.size - treeSize > 1) {
                runReverseDfs(parent, i, xorOne)
            }
            return Info(xorOne, treeSize)
        }

        dfs(0, -1)

        return ans.toInt()
    }
}

/*
9, 14, 2, 1

0(9) -- 3(1) -- 1(14)
        |
       2(2)
*/