cache = []

def solve(i, j):
    global cache
    if i < 0 or j < 0:
        return 0

    if i == 0 and j == 0:
        return 1

    if cache[i][j] == -1:
        cache[i][j] = solve(i - 1, j) + solve(i, j - 1)

    return cache[i][j]


def numberOfWaysToTraverseGraph(width, height):
    global cache
    cache = [[-1 for _ in range(height)] for _ in range(width)]
    return solve(width - 1, height - 1)

print(numberOfWaysToTraverseGraph(2, 3))
print(numberOfWaysToTraverseGraph(3, 4))
