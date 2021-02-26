# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param A : root node of tree
    # @param B : integer
    # @return an integer

    def traverse(self, A, B, res):
        if A is None:
            return

        self.traverse(A.left, B, res)
        B -= 1
        if B == 0:
            res = A.val
            return
        self.traverse(A.right, B, res)

    def kthsmallest(self, A, B):
        res = None
        self.traverse(A, B, res)
        return res


root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)

print(Solution().kthsmallest(root, 2))
