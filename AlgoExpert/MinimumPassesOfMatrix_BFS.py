def is_valid_coordinate(i, j, a):
    n = len(a)
    if i < 0 or i >= n:  # over boundary
        return False
    m = len(a[i])
    if j < 0 or j >= m:  # over boundary
        return False

    return True

def minimumPassesOfMatrix(a):
    
    positives = []
    n = len(a)

    for i in range(n):
        m = len(a[i])
        for j in range(m):
            if a[i][j] > 0:
                positives.append((i, j))

    pass_count = 0
    while len(positives) > 0:
        nwe_positives = []
        for i, j in positives:
            dirX = [-1, 1, 0, 0]
            dirY = [0, 0, -1, 1]
            for k in range(4):
                new_i = i + dirX[k]
                new_j = j + dirY[k]
                if not is_valid_coordinate(new_i, new_j, a):
                    continue
                if a[new_i][new_j] < 0:
                    a[new_i][new_j] *= -1
                    nwe_positives.append((new_i, new_j))
        if len(nwe_positives) > 0:
            pass_count += 1
        positives = nwe_positives

    # check if still there is any negative
    for i in range(n):
        m = len(a[i])
        for j in range(m):
            if a[i][j] < 0:
                return -1
    return pass_count


a = [
    [0, -1, -3, 2, 0],
    [1, -2, -5, -1, -3],
    [3, 0, 0, -4, -1]
]
print(minimumPassesOfMatrix(a))

a = [
    [0,   0, -1, -2],
    [-2,  -3,  4, -1],
    [-2,  -3,  1, -3],
    [-14, -15,  2,  0],
    [0,   0,  0,  0],
    [1,  -1, -1,  1]
]
print(minimumPassesOfMatrix(a))
