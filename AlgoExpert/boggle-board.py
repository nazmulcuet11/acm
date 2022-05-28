class Trie:
    class Node:
        def __init__(self):
            self.childs = {}
            self.endMark = False

    def __init__(self):
        self.root = self.Node()

    def add(self, word):
        current = self.root
        for char in word:
            if char not in current.childs:
                current.childs[char] = self.Node()
            current = current.childs[char]
        current.endMark = True


def boggleBoard(board, words):
    def isValid(i, j):
        if i < 0 or i >= len(board):
            return False
        if j < 0 or j >= len(board[i]):
            return False
        return True

    dirX = [0, 0, 1, -1, -1, -1, 1, 1]
    dirY = [1, -1, 0, 0, -1, 1, -1, 1]

    visited = [[False for col in row] for row in board]
    ans = set()

    def explore(i, j, w, node):
        if not node:
            return

        if node.endMark:
            ans.add(w)

        if not isValid(i, j):
            return

        if visited[i][j]:
            return

        char = board[i][j]
        visited[i][j] = True
        for k in range(8):
            newI, newJ = i + dirX[k], j + dirY[k]
            explore(newI, newJ, w + char, node.childs.get(char, None))
        visited[i][j] = False

    trie = Trie()
    for word in words:
        trie.add(word)

    for i in range(len(board)):
        for j in range(len(board[i])):
            explore(i, j, "", trie.root)

    return ans
