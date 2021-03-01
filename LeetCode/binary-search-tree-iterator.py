
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    def update_stk(self, root):
        while root:
            self.stk.append(root)
            root = root.left

    def __init__(self, root: TreeNode):
        self.stk = []
        self.update_stk(root)

    def next(self) -> int:
        root = self.stk.pop()
        self.update_stk(root.right)
        return root.val

    def hasNext(self) -> bool:
        return len(self.stk) > 0


root = TreeNode(4)

root.left = TreeNode(2)
root.right = TreeNode(6)

root.left.left = TreeNode(1)
root.left.right = TreeNode(3)

root.right.left = TreeNode(5)
root.right.right = TreeNode(7)

ita = BSTIterator(root)
while ita.hasNext():
    print(ita.next())
