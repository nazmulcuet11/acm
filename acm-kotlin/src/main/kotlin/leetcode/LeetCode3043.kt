package leetcode

import kotlin.math.max

class LeetCode3043 {
    data class TrieNode(
        var children: MutableMap<Char, TrieNode> = mutableMapOf()
    )

    private var trieRoot = TrieNode()
    private var maxPrefixLength = 0

    private fun insert(word: String) {
        var curr = trieRoot
        for (c in word) {
            curr.children[c]?.let {
                curr = it
            } ?: run {
                val node = TrieNode()
                curr.children[c] = node
                curr = node
            }
        }
    }

    private fun matchPrefix(word: String) {
        var prefixLength = 0
        var curr = trieRoot
        for (c in word) {
            val node = curr.children[c] ?: break
            prefixLength++
            curr = node
        }
        maxPrefixLength = max(maxPrefixLength, prefixLength)
    }

    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        trieRoot = TrieNode()
        maxPrefixLength = 0

        for (num in arr1) {
            insert(num.toString())
        }

        for (num in arr2) {
            matchPrefix(num.toString())
        }

        return maxPrefixLength
    }
}