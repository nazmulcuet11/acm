# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BSTIterator:
    def update_stk(self, root):
        while root:
            self.stk.append(root)
            if self.asc:
                root = root.left
            else:
                root = root.right

    def __init__(self, root: TreeNode, asc=True):
        self.stk = []
        self.asc = asc
        self.update_stk(root)

    def next(self) -> int:
        root = self.stk.pop()
        if self.asc:
            self.update_stk(root.right)
        else:
            self.update_stk(root.left)
        return root.val

    def value(self) -> int:
        if self.hasNext():
            return self.stk[-1].val
        return -1

    def hasNext(self) -> bool:
        return len(self.stk) > 0


def get_node_count(root):
    if root is None:
        return 0
    x = get_node_count(root.left)
    y = get_node_count(root.right)
    return x + y + 1


class Solution:
    # @param A : root node of tree
    # @param B : integer
    # @return an integer
    def t2Sum(self, A, B):
        forward_ita = BSTIterator(A)
        backward_ita = BSTIterator(A, asc=False)

        node_count = get_node_count(A)
        forward_cnt = 1
        backward_cnt = 1

        while forward_ita.hasNext() and backward_ita.hasNext():
            if forward_cnt + backward_cnt > node_count:
                # two pointer crossed each other
                return 0

            x = forward_ita.value()
            y = backward_ita.value()
            t = x + y

            if t == B:
                return 1
            elif t < B:
                forward_ita.next()
                forward_cnt += 1
            else:
                backward_ita.next()
                backward_cnt += 1
        return 0


root = TreeNode(4)

root.left = TreeNode(2)
root.right = TreeNode(6)

root.left.left = TreeNode(1)
root.left.right = TreeNode(3)

root.right.left = TreeNode(5)
root.right.right = TreeNode(7)

print(get_node_count(root))

ita = BSTIterator(root, asc=False)
while ita.hasNext():
    print(ita.next())


root = TreeNode(10)
root.left = TreeNode(9)
root.right = TreeNode(20)
print(get_node_count(root))

# print(Solution().t2Sum(root, 19))
print(Solution().t2Sum(root, 40))
