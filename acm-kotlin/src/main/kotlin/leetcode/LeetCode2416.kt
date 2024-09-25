package leetcode

class LeetCode2416 {
    private data class TrieNode(
        var count: Int = 0,
        var children: MutableMap<Char, TrieNode> = mutableMapOf()
    )

    private var root = TrieNode()

    private fun insert(word: String) {
        var curr = root
        for (c in word) {
            curr.children[c]?.let {
                it.count++
                curr = it
            } ?: run {
                val node = TrieNode()
                node.count = 1
                curr.children[c] = node
                curr = node
            }
        }
    }

    private fun prefixSum(word: String): Int {
        var sum = 0
        var curr = root
        for (c in word) {
            val node = curr.children[c] ?: break
            sum += node.count
            curr = node
        }
        return sum
    }

    fun sumPrefixScores(words: Array<String>): IntArray {
        root = TrieNode()
        for (word in words) {
            insert(word)
        }

        val ans = mutableListOf<Int>()
        for (word in words) {
            ans.add(prefixSum(word))
        }
        return ans.toIntArray()
    }
}