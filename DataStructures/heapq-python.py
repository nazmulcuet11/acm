import heapq

# hq = [21, 1, 45, 78, 3, 5]
# heapq.heapify(hq)
# print(hq)

# heapq.heappush(hq, 8)
# print(hq)

# top = heapq.heappop(hq)
# print(top)
# print(hq)
# top = heapq.heappop(hq)
# print(top)
# print(hq)


class Node(object):
    def __init__(self, val: int):
        self.val = val

    def __repr__(self):
        return f'{self.val}'

    def __eq__(self, other):
        return self.val == other.val

    def __lt__(self, other):
        return self.val > other.val


hq = [Node(21), Node(1), Node(45), Node(78), Node(3), Node(5)]
heapq.heapify(hq)
print(hq)

heapq.heappush(hq, Node(8))
print(hq)

top = heapq.heappop(hq)
print(top)
print(hq)
top = heapq.heappop(hq)
print(top)
print(hq)
