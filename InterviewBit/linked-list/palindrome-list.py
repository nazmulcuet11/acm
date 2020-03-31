class Node:
    def __init__(self, x, next):
        self.val = x
        self.next = next

def reverse_list(node):
    prev = None
    while node:
        t = node
        node = node.next
        t.next = prev
        prev = t
    return prev

class Solution:
    # @param A : head node of linked list
    # @return an integer
    def lPalin(self, node):
        # Reverse first half of the linked list
        slow = fast = node
        prev = None
        while fast and fast.next:
            fast = fast.next.next
            t = slow
            slow = slow.next
            t.next = prev
            prev = t

        # Odd lenght, slow is the middle node
        if fast:
            slow = slow.next

        # Prev is at the root of the reversed first half
        # Slow is at the begining of second half
        while prev and slow:
            if prev.val != slow.val:
                return 0
            prev = prev.next
            slow = slow.next

        return 1

root = Node(1, Node(2, Node(3, Node(2, Node(1, None)))))
# reversed_root = reverse_list(root)
# print(root.val)
# print(reversed_root.val)
print(Solution().lPalin(root))
root = Node(1, Node(2, Node(3, Node(1, None))))
print(Solution().lPalin(root))


