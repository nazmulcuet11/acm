# DFS Solution
def is_valid_coordinate(i, j, a):
    n = len(a)
    if i < 0 or i >= n: # over boundary
        return False
    m = len(a[i])
    if j < 0 or j >= m: # over boundary
        return False

    return True

def populateDist(i, j, a, d):
    if a[i][j] <= 0:
        return

    dirX = [-1, 1, 0, 0]
    dirY = [0, 0, -1, 1]
    for k in range(4):
        new_i = i + dirX[k]
        new_j = j + dirY[k]
        if not is_valid_coordinate(new_i, new_j, d):
            continue
        if d[new_i][new_j] <= d[i][j] + 1:
            continue

        if a[new_i][new_j] < 0:
            a[new_i][new_j] = -a[new_i][new_j]

        d[new_i][new_j] = d[i][j] + 1
        populateDist(new_i, new_j, a, d)

def minimumPassesOfMatrix(a):
    # setup
    d = []
    INF = 10000000000
    n = len(a)
    for i in range(n):
        m = len(a[i])
        t = []
        for j in range(m):
            if a[i][j] >= 0:
                t.append(0)
            else:
                t.append(INF)
        d.append(t)
    
    # print(d)
    # print(vis)

    # populate
    for i in range(n):
        m = len(d[i])
        for j in range(m):
            if d[i][j] == 0:
                populateDist(i, j, a, d)

    # print(d)
    # print(vis)

    # calculate
    mx = 0
    for i in range(n):
        m = len(d[i])
        for j in range(m):
            mx = max(mx, d[i][j])

    if mx == INF:
        return -1

    return mx


a = [
    [0, -1, -3, 2, 0],
    [1, -2, -5, -1, -3],
    [3, 0, 0, -4, -1]
]
print(minimumPassesOfMatrix(a))

a = [
    [  0,   0, -1, -2],
    [ -2,  -3,  4, -1],
    [ -2,  -3,  1, -3],
    [-14, -15,  2,  0],
    [  0,   0,  0,  0],
    [  1,  -1, -1,  1]
]
print(minimumPassesOfMatrix(a))
