class Node:
    def __init__(self, x, next):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def remove_duplicate(node):
    root = prev = node
    while node:
        if prev.val == node.val:
            node = node.next
        else:
            prev.next = node
            prev = prev.next
    # last value is duplicated multiple times
    prev.next = None
    return root
    
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the head node in the linked list
    def deleteDuplicates(self, A):
        return remove_duplicate(A)

root = Node(1, Node(2, Node(3, Node(4, Node(4, None)))))
print_list(root)
root = Node(1, Node(1, Node(1, Node(2, Node(2, Node(2, Node(3, Node(4, Node(4, Node(4, Node(5, Node(5, Node(5, None)))))))))))))
print_list(root)
root = remove_duplicate(root)
print_list(root)
root = Node(1, Node(1, Node(1, None)))
print_list(root)
root = remove_duplicate(root)
print_list(root)

