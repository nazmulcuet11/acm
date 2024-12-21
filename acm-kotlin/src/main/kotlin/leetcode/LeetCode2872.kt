package leetcode

class LeetCode2872 {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        // build tree
        val tree = Array<MutableSet<Int>>(n) { mutableSetOf() }
        for (e in edges) {
            tree[e[0]].add(e[1])
            tree[e[1]].add(e[0])
        }

        // start with leaf nodes
        val q = ArrayDeque<Int>()
        for (i in tree.indices) {
            if (tree[i].size <= 1) {
                q.add(i)
            }
        }

        var ans = 0
        val longValues = values.map { it.toLong() }.toLongArray()
        while (q.isNotEmpty()) {
            val t = q.removeFirst()
            if (tree[t].isEmpty()) {
                // already a separate component
                ans++
                continue
            }

            val p = tree[t].first()

            if (longValues[t] % k.toLong() == 0L) {
                // count as a separate component
                ans++
            } else {
                // can't be separate, merge with parent
                longValues[p] += longValues[t]
                longValues[t] = 0
            }

            // disconnect
            tree[t].remove(p)
            tree[p].remove(t)
            if (tree[p].size == 1) {
                q.add(p)
            }
        }
        return ans
    }
}