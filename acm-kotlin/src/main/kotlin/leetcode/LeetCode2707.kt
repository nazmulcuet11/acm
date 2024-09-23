package leetcode

import kotlin.math.min

class LeetCode2707 {
    data class TrieNode(
        var end: Boolean = false,
        var children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>()
    )

    private var s = ""
    private var cache = mutableMapOf<Int, Int>()
    private var trieRoot = TrieNode()

    private fun insertIntoTrie(word: String) {
        var currentNode = trieRoot
        for (c in word) {
            currentNode.children[c]?.let {
                currentNode = it
            } ?: run {
                val node = TrieNode()
                currentNode.children[c] = node
                currentNode = node
            }
        }
        currentNode.end = true
    }

    private fun solve(i: Int): Int {
        if (i == s.length) {
            return 0
        }

        cache[i]?.let {
            return it
        }

        var result = 1 + solve(i + 1) // skip
        var current = trieRoot
        for (j in i until s.length) {
            val child = current.children[s[j]]
            if (child == null) {
                break
            } else {
                current = child
                if (child.end) {
                    result = min(result, solve(j + 1))
                }
            }
        }
        cache[i] = result
        return result
    }

    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        this.s = s
        this.trieRoot = TrieNode()
        for (word in dictionary) {
            insertIntoTrie(word)
        }
        cache = mutableMapOf<Int, Int>()
        return solve(0)
    }
}
