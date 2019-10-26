### ------ Spiral Order Matrix 1  Rescursive ------ ###

# stepX = [ 0, 1, 0,-1]
# stepY = [ 1, 0,-1, 0]

# def dfs(arr, mask, i, j, ret, dir):
#     if i < 0 or j < 0 or i >= len(arr) or j >= len(arr[0]):
#         return
#     if mask[i][j]:
#         return

#     mask[i][j] = True
#     ret.append(arr[i][j])
#     for x in range(4):
#         newDir = (dir + x) % 4
#         dfs(arr, mask, i + stepX[newDir], j + stepY[newDir], ret, newDir)


### ------ Spiral Order Matrix 1 ------ ###

# class Solution:
#     # @param A : tuple of list of integers
#     # @return a list of integers
#     def spiralOrder(self, A):
#         T, L, B, R = 0, 0, len(A)-1, len(A[0])-1
#         ret = []
#         dir = 0
#         while L <= R and T <= B:
#             if dir == 0:
#                 for k in range(L, R+1):
#                     ret.append(A[T][k])
#                 T += 1
#             elif dir == 1:
#                 for k in range(T, B+1):
#                     ret.append(A[k][R])
#                 R -= 1
#             elif dir == 2:
#                 for k in range(R, L-1, -1):
#                     ret.append(A[B][k])
#                 B -= 1
#             else:
#                 for k in range(B, T-1, -1):
#                     ret.append(A[k][L])
#                 L += 1
#             dir = (dir + 1) % 4

#         return ret

# arr = [
#     [ 1, 2, 3 ],
#     [ 4, 5, 6 ],
#     [ 7, 8, 9 ]
# ]
# print(Solution().spiralOrder(arr))

class Solution:
    # @param A : integer
    # @return a list of list of integers
    def generateMatrix(self, N):
        T, L, B, R = 0, 0, N-1, N-1
        A = [[0 for _ in range(N)] for _ in range(N)]
        x, dir = 1, 0
        while L <= R and T <= B:
            if dir == 0:
                for k in range(L, R+1):
                    A[T][k] = x
                    x += 1
                T += 1
            elif dir == 1:
                for k in range(T, B+1):
                    A[k][R] = x
                    x += 1
                R -= 1
            elif dir == 2:
                for k in range(R, L-1, -1):
                    A[B][k] = x
                    x += 1
                B -= 1
            else:
                for k in range(B, T-1, -1):
                    A[k][L] = x
                    x += 1
                L += 1
            dir = (dir + 1) % 4

        return A

print(Solution().generateMatrix(3))
print(Solution().generateMatrix(4))
    

