class Point:
    def __init__(self, x = 0, y = 0):
        self.x = x
        self.y = y

def make_vecrot(a, b):
    return Point(b.x - a.x, b.y - a.y)

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return an integer
    def maxPoints(self, X, Y):
        if len(X) == 0:
            return 0

        max_points = 0
        for i in range(len(X)):
            seen = {}
            dup, curr_max = 0, 0
            for j in range(i + 1, len(X)):
                p = make_vecrot(Point(X[i], Y[i]), Point(X[j], Y[j]))
                if p.x == 0 and p.y == 0:
                    dup += 1
                    continue
                if p.x < 0:
                    p.x *= -1
                    p.y *= -1
                g = gcd(p.x, p.y)
                p.x /= g
                p.y /= g
                seen[(p.x, p.y)] = seen.get((p.x, p.y), 0) + 1
                curr_max = max(curr_max, seen[(p.x, p.y)])
            max_points = max(max_points, curr_max + dup)

        return max_points + 1




print(Solution().maxPoints([-6, 5, -18, 2, 5, -2], [-17, -16, -17, -4, -13, 20]))
print(Solution().maxPoints([1, 1, 1], [0, 4, -1]))
