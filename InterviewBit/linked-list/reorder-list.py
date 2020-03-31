class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

class Solution:
    # @param A : head node of linked list
    # @return the head node in the linked list
    def reorderList(self, node):
        if not node:
            return node

        slow = fast = node
        prev = final = None
        while fast and fast.next:
            fast = fast.next.next
            t = slow
            slow = slow.next
            t.next = prev
            prev = t

        # Odd lenght, slow is the middle node
        if fast:
            final = slow
            slow = slow.next
            final.next = None

        # Prev is at the root of the reversed first half
        # Slow is at the begining of second half
        while prev and slow:
            x = prev
            y = slow
            prev = prev.next
            slow = slow.next
            x.next = y
            y.next = final
            final = x

        return final


root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)
root = Solution().reorderList(root)
print_list(root)