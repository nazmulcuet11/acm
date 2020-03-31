class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def rev_k(node, k):
    prev = None
    while node and k:
        t = node
        node = node.next
        t.next = prev
        prev = t
        k -= 1
    return (prev, node)
    

class Solution:
    # @param A : head node of linked list
    # @param B : integer
    # @return the head node in the linked list
    def reverseList(self, node, k):
        prevTail = node
        root, node = rev_k(node, k)
        while node:
            newTail = node
            head, node = rev_k(node, k)
            prevTail.next = head
            prevTail = newTail
        return root

root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)
root = Solution().reverseList(root, 3)
print_list(root)
prev, next = rev_k(root, 1)
print_list(prev)
print_list(next)