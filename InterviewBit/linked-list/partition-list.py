class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def partition(node, k):
    lower_root = lower_tail = upper_root = prev = None
    running = node
    while running:
        if running.val < k:
            if not lower_root:
                lower_root = lower_tail = running
            else:
                lower_tail.next = running
                lower_tail = lower_tail.next 

            # Detach running from linked list
            if prev:
                prev.next = running.next
        else:
            if not upper_root:
                upper_root = running
            prev = running
        running = running.next

    if not lower_root:
        return upper_root
    lower_tail.next = upper_root
    return lower_root

class Solution:
    # @param A : head node of linked list
    # @param B : integer
    # @return the head node in the linked list
    def partition(self, A, B):
        return partition(A, B)

root = ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5, ListNode(2, ListNode(4)))))))
print_list(root)
root = partition(root, 3)
print_list(root)