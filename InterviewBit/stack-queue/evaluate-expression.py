class Solution:
    # @param A : list of strings
    # @return an integer
    def evalRPN(self, A):
        stack = []
        operators = ['+', '-', '*', '/']
        for c in A:
            if c in operators:
                b = stack.pop()
                a = stack.pop()
                if c == '+':
                    stack.append(a + b)
                elif c == '-':
                    stack.append(a - b)
                elif c == '*':
                    stack.append(a * b)
                else:
                    stack.append(a // b)
            else:
                stack.append(int(c))
        return stack[0]
