class Solution:
    def dfs(self, board, x, y, stepX, stepY):
        if  x < 0 or x >= len(board) or y < 0 or y >= len(board[0]):
            return None
        if board[x][y]:
            return [x, y]
        
        return self.dfs(board, x + stepX, y + stepY, stepX, stepY)


    def queensAttacktheKing(self, queens, king):
        ans = []
        board = [[0 for _ in range(8)] for _ in range(8)]
        for queen in queens:
            x, y = queen[0], queen[1]
            board[x][y] = 1

        stepX = [ 1, 0,-1, 0, 1, 1,-1,-1]
        stepY = [ 0, 1, 0,-1, 1,-1, 1,-1]
        for index in range(len(stepX)):
            pos = self.dfs(board, king[0] + stepX[index], king[1] + stepY[index], stepX[index], stepY[index]) 
            if pos != None:
                ans.append(pos)

        return ans



print(Solution().queensAttacktheKing([[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], [0, 0]))

print(Solution().queensAttacktheKing([[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], [3, 3]))

print(Solution().queensAttacktheKing([[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], [3, 4]))

print(Solution().queensAttacktheKing([[4,7],[1,3],[6,6],[3,0],[0,2],[0,7],[6,2],[3,7],[5,1],[2,5],[0,3],[7,2],[4,0],[1,2],[3,3],[5,5],[4,4],[6,3],[1,5],[5,0],[0,4],[6,4],[5,4],[3,2],[0,0],[4,5],[0,5],[2,3],[1,0],[6,5],[5,3],[0,1],[7,0],[4,6],[5,7],[7,4],[2,0],[4,3],[3,4]], [2,4]))