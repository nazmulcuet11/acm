from enum import Enum


class Positions(Enum):
    TOP_LEFT = 0
    TOP_RIGHT = 1
    BOTTOM_LEFT = 2
    BOTTOM_RIGHT = 3
    LEFT_SIDE = 4
    TOP_SIDE = 5
    RIGHT_SIDE = 6
    BOTTOM_SIDE = 7
    MIDDLE = 8


class Directions(Enum):
    RIGHT = 0
    DOWN = 1
    UP_DIAGONAL = 2
    DOWN_DIAGONAL = 3


def getPosition(i, j, array):
    n = len(array)
    m = len(array[0])

    if i == 0 and j == 0:
        return Positions.TOP_LEFT
    if i == 0 and j == m - 1:
        return Positions.TOP_RIGHT
    if i == n - 1 and j == 0:
        return Positions.BOTTOM_LEFT
    if i == n - 1 and j == m - 1:
        return Positions.BOTTOM_RIGHT
    if j == 0:
        return Positions.LEFT_SIDE
    if i == 0:
        return Positions.TOP_SIDE
    if j == m - 1:
        return Positions.RIGHT_SIDE
    if i == n - 1:
        return Positions.BOTTOM_SIDE

    return Positions.MIDDLE


def getPositionModifier(direction):
    modifiers = {
        Directions.RIGHT: (0, 1),
        Directions.DOWN: (1, 0),
        Directions.UP_DIAGONAL: (-1, 1),
        Directions.DOWN_DIAGONAL: (1, -1)
    }

    return modifiers[direction]


def zigzagTraverse(array):
    n = len(array)
    m = len(array[0])

    if n == 1:
        return array[0]
    if m == 1:
        ans = []
        for row in array:
            ans += row
        return ans

    direction = None
    i, j = 0, 0
    ans = []

    while True:
        ans.append(array[i][j])

        p = getPosition(i, j, array)

        if p == Positions.TOP_LEFT:
            direction = Directions.DOWN

        elif p == Positions.TOP_RIGHT:
            if direction == Directions.RIGHT:
                direction = Directions.DOWN_DIAGONAL
            elif direction == Directions.UP_DIAGONAL:
                direction = Directions.DOWN

        if p == Positions.BOTTOM_LEFT:
            if direction == Directions.DOWN:
                direction = Directions.UP_DIAGONAL
            elif direction == Directions.DOWN_DIAGONAL:
                direction = Directions.RIGHT

        elif p == Positions.BOTTOM_RIGHT:
            break

        if p == Positions.LEFT_SIDE:
            if direction == Directions.DOWN:
                direction = Directions.UP_DIAGONAL
            elif direction == Directions.DOWN_DIAGONAL:
                direction = Directions.DOWN

        elif p == Positions.TOP_SIDE:
            if direction == Directions.RIGHT:
                direction = Directions.DOWN_DIAGONAL
            elif direction == Directions.UP_DIAGONAL:
                direction = Directions.RIGHT

        if p == Positions.RIGHT_SIDE:
            if direction == Directions.DOWN:
                direction = Directions.DOWN_DIAGONAL
            elif direction == Directions.UP_DIAGONAL:
                direction = Directions.DOWN

        elif p == Positions.BOTTOM_SIDE:
            if direction == Directions.RIGHT:
                direction = Directions.UP_DIAGONAL
            elif direction == Directions.DOWN_DIAGONAL:
                direction = Directions.RIGHT

        x, y = getPositionModifier(direction)
        i += x
        j += y

    return ans


# array = [
#     [1, 3, 4, 10],
#     [2, 5, 9, 11],
#     [6, 8, 12, 15],
#     [7, 13, 14, 16]
# ]
# print(zigzagTraverse(array))


array = [
    [1, 2, 3, 4, 5]
]
print(zigzagTraverse(array))
