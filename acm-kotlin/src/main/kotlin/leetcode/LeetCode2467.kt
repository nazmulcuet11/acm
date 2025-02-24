package leetcode

import kotlin.math.max

class LeetCode2467 {
    private var n = 0
    private var tree = Array(0) { mutableListOf<Int>() }
    private var parent = intArrayOf()
    private var amount = intArrayOf()
    private var bobNodeToTime = intArrayOf()

    private fun buildTree(edges: Array<IntArray>) {
        for (e in edges) {
            tree[e[0]].add(e[1])
            tree[e[1]].add(e[0])
        }
    }

    private fun populateParent(n: Int, p: Int) {
        parent[n] = p
        for (c in tree[n]) {
            if (c != p) {
                populateParent(c, n)
            }
        }
    }

    private fun moveBob(n: Int, t: Int) {
        if (n == -1) {
            return
        }
        bobNodeToTime[n] = t
        moveBob(parent[n], t + 1)
    }

    private fun moveAlice(n: Int, t: Int): Int {
        var profitFromNode = 0
        if (bobNodeToTime[n] == -1 || bobNodeToTime[n] > t) {
            profitFromNode += amount[n]
        } else if (bobNodeToTime[n] == t) {
            profitFromNode += amount[n] / 2
        }

        var maxProfitFromChild = Int.MIN_VALUE
        for (c in tree[n]) {
            if (c != parent[n]) {
                maxProfitFromChild = max(
                    maxProfitFromChild,
                    moveAlice(c, t + 1)
                )
            }
        }

        if (maxProfitFromChild == Int.MIN_VALUE) {
            return profitFromNode
        }
        return profitFromNode + maxProfitFromChild
    }

    fun mostProfitablePath(
        edges: Array<IntArray>,
        bob: Int,
        amount: IntArray
    ): Int {
        this.n = amount.size
        this.amount = amount

        this.tree = Array(n) { mutableListOf() }
        buildTree(edges)

        this.parent = IntArray(n) { -1 }
        populateParent(0, -1)

        this.bobNodeToTime = IntArray(n) { -1 }
        moveBob(bob, 0)

        return moveAlice(0, 0)
    }
}
