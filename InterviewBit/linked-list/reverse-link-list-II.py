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
    # @param B : integer
    # @param C : integer
    # @return the head node in the linked list
    def reverseBetween(self, node, m, n):
        if not node:
            return node

        start = end = node
        prevStrt = prevEnd = None
        while n:
            if m > 1:
                prevStrt = start
                start = start.next
                m -= 1
            if n > 0:
                if m == 1 and end != start and prevEnd:
                    t = end
                    end = end.next
                    t.next = prevEnd
                    prevEnd = t
                else:
                    prevEnd = end
                    end = end.next
                n -= 1

        if not prevStrt: 
            start.next = end
            return prevEnd
        else:
            prevStrt.next = prevEnd
            start.next = end
            return node


root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)
root = Solution().reverseBetween(root, 1, 5)
print_list(root)