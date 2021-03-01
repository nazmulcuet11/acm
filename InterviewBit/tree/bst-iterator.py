# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:
    def update_stk(self, root):
        while root:
            self.stk.append(root)
            root = root.left

    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.stk = []
        self.update_stk(root)

    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return len(self.stk) > 0

    # @return an integer, the next smallest number
    def next(self):
        if not self.hasNext():
            return -1

        root = self.stk.pop()
        self.update_stk(root.right)
        return root.val
