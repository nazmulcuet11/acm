from queue import PriorityQueue


class Node(object):
    def __init__(self, val: int):
        self.val = val

    def __repr__(self):
        return f'{self.val}'

    def __eq__(self, other):
        return self.val == other.val

    def __lt__(self, other):
        return self.val < other.val


q = PriorityQueue()
q.put(Node(21))
q.put(Node(1))
q.put(Node(45))
q.put(Node(78))
q.put(Node(3))
q.put(Node(5))

top = q.get()
print(top)
q.put(Node(90))
top = q.get()
print(top)
