class Solution:
    def __init__(self):
        self.MOD = 1e9 + 7

        self.next = {
            0: [4, 6],
            1: [6, 8],
            2: [7, 9],
            3: [4, 8],
            4: [0, 3, 9],
            5: [],
            6: [0, 1, 7],
            7: [2, 6],
            8: [1, 3],
            9: [2, 4]
        }

        self.cache = [[]]

    def calculateForIndices(self, a, n):
        s = 0
        for i in a:
            s = (s + self.calculate(i, n)) % self.MOD
        return int(s)

    def calculate(self, i, n):
        if n == 1:
            return 1

        if self.cache[i][n] != -1:
            return self.cache[i][n]

        self.cache[i][n] = self.calculateForIndices(self.next[i], n - 1)
        return self.cache[i][n]

    def knightDialer(self, n: int) -> int:
        self.cache = [[-1] * (n + 1) for _ in range(11)]
        return self.calculateForIndices([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], n)
