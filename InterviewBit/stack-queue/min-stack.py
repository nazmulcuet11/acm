class MinStack:
    def __init__(self):
        self.stack = []
        self.mn_stack = []

    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stack.append(x)
        mn = x if len(self.mn_stack) == 0 else min(x, self.mn_stack[-1])
        self.mn_stack.append(mn)

    # @return nothing
    def pop(self):
        if len(self.stack) > 0:
            self.stack.pop()
            self.mn_stack.pop()

    # @return an integer
    def top(self):
        if len(self.stack) > 0:
            return self.stack[-1]
        return -1

    # @return an integer
    def getMin(self):
        if len(self.mn_stack) > 0:
            return self.mn_stack[-1]
        return -1


s = MinStack()
s.push(2)
s.push(1)
print(s.getMin())
s.pop()
print(s.getMin())
# s.pop()
print(s.getMin())

t = MinStack()
print(t.getMin())