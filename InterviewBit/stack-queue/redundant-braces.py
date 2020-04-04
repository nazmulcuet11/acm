class Solution:
    # @param A : string
    # @return an integer
    def braces(self, expression):
        stack = []
        valid_operators = ['+', '-', '*', '/']
        for c in expression:
            if c == ' ':
                continue
            if c == ')':
                has_expression = False
                opening_found = False
                while len(stack) > 0:
                    t = stack.pop()
                    if t == '(':
                        opening_found = True
                        break
                    if t in valid_operators:
                        has_expression = True
                if not has_expression or not opening_found:
                    return 1
            else:
                stack.append(c)
        
        for c in stack:
            if c == '(':
                return 1
        return 0


print(Solution().braces("((a + b))"))
print(Solution().braces("(a + (a + b))"))
print(Solution().braces("a + b"))
print(Solution().braces("(a)")) 