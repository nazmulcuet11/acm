package leetcode

import java.util.*
import kotlin.math.abs
import kotlin.math.min

class LeetCode127 {
    private var beginWord: String = ""
    private var endWord: String = ""
    private var wordList = listOf<String>()
    private var graph = mutableMapOf<String, MutableList<String>>()

    private fun countDiff(a: String, b: String): Int {
        var count = abs(a.length - b.length)
        for (i in 0..<min(a.length, b.length)) {
            if (a[i] != b[i]) {
                count++
            }
        }
        return count
    }

    private fun isSingleCharDiff(a: String, b: String): Boolean {
        return countDiff(a, b) == 1
    }

    private fun makeEdge(u: String, v: String) {
        graph[u]?.add(v) ?: run {
            graph[u] = mutableListOf(v)
        }
    }

    private fun generateGraph() {
        // connect words from word list
        for (i in wordList.indices) {
            for (j in i + 1..<wordList.size) {
                if (isSingleCharDiff(wordList[i], wordList[j])) {
                    makeEdge(wordList[i], wordList[j])
                    makeEdge(wordList[j], wordList[i])
                }
            }
        }

        if (graph[beginWord] == null) {
            // connect begin word to the rest of the graph
            for (word in wordList) {
                if (isSingleCharDiff(beginWord, word)) {
                    makeEdge(beginWord, word)
                }
            }
        }
    }

    private fun runBFS(): Int {
        val cost = mutableMapOf<String, Int>()
        val queue: Queue<String> = LinkedList()
        queue.add(beginWord)
        cost[beginWord] = 1
        while (queue.isEmpty().not()) {
            val u = queue.poll()
            if (u == endWord) {
                break
            }
            for (v in graph[u] ?: listOf()) {
                if (cost[v] == null) {
                    cost[v] = cost[u]!! +  1
                    queue.add(v)
                }
            }
        }
        return cost.getOrDefault(endWord, 0)
    }

    fun ladderLength(
        beginWord: String,
        endWord: String,
        wordList: List<String>
    ): Int {
        this.beginWord = beginWord
        this.endWord = endWord
        this.wordList = wordList
        this.graph = mutableMapOf<String, MutableList<String>>()

        generateGraph()
        return runBFS()
    }
}