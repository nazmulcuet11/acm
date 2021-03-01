# Definition for a  binary tree node
# class TreeNode:
#    def __init__(self, x):
#        self.val = x
#        self.left = None
#        self.right = None

class Solution:
    # @param A : root node of tree
    # @param B : integer
    # @return an integer

    def traverse(self, A, B):
        if A is None:
            return

        self.traverse(A.left, B)
        self.count += 1
        if self.count == B:
            self.target = A.val
            return
        self.traverse(A.right, B)

    def kthsmallest(self, A, B):
        self.count = 0
        self.target = None
        self.traverse(A, B)
        return self.target
