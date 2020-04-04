class Solution:
    # @param A : string
    # @return a strings
    def simplifyPath(self, absolute_path):
        path_components = absolute_path.split("/")
        stack = []
        for pc in path_components:
            if pc == '' or pc == ".":
                continue
            if pc == "..":
                if len(stack) > 0:
                    stack.pop()
            else:
                stack.append(pc)
        return "/" + "/".join(stack)

print(Solution().simplifyPath("/../"))
print(Solution().simplifyPath("/home"))
print(Solution().simplifyPath("/a/./b/../../c/"))
print(Solution().simplifyPath("/home/./a/./b"))