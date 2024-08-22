package leetcode

class LeetCode212 {
    data class TrieNode(
        var end: Boolean = false,
        var children: MutableMap<Char, TrieNode> = mutableMapOf(),
    )

    data class Position(
        val x: Int,
        val y: Int,
    )

    data class Move(
        val x: Int,
        val y: Int,
    )

    private var root = TrieNode()
    private var board: Array<CharArray> = arrayOf()
    private var maxWordLength = 0
    private val moves = listOf(
        Move(0, 1),
        Move(1, 0),
        Move(0, -1),
        Move(-1, 0),
    )

    private fun isValidPosition(p: Position): Boolean {
        return 0 <= p.x && p.x < board.size && 0 <= p.y && p.y < board[p.x].size
    }

    private fun getNewPositions(p: Position): List<Position> {
        val newPositions = mutableListOf<Position>()
        for (move in moves) {
            val newPosition = Position(p.x + move.x, p.y + move.y)
            if (isValidPosition(newPosition)) {
                newPositions.add(newPosition)
            }
        }
        return newPositions
    }

    private fun generate(
        p: Position,
        node: TrieNode,
        l: Int
    ) {
        // we only need up to l length words
        if (l == 0) {
            return
        }

        val ch = board[p.x][p.y]
        if (ch == '#') {
            return
        }

        // insert
        val newNode = node.children[ch] ?: TrieNode()
        node.children[ch] = newNode

        board[p.x][p.y] = '#'
        val newPositions = getNewPositions(p)
        for (np in newPositions) {
            generate(np, newNode, l - 1)
        }
        board[p.x][p.y] = ch
    }

    private fun populateTrie() {
        for (i in board.indices) {
            for (j in board[i].indices) {
                generate(Position(i, j), root, maxWordLength)
            }
        }
    }

    private fun check(word: String): Boolean {
        var curr = root
        for (ch in word) {
            curr.children[ch]?.let {
                curr = it
            } ?: run {
                return false
            }
        }
        return true
    }

    fun findWords(
        board: Array<CharArray>,
        words: Array<String>
    ): List<String> {
        this.board = board
        this.root = TrieNode()
        this.maxWordLength = words.maxOf { it.length }

        populateTrie()

        val ans = mutableListOf<String>()
        for (word in words) {
            if (check(word)) {
                ans.add(word)
            }
        }
        return ans
    }
}