class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def remove_nth_from_end(node, n):
    first = second = node
    prev = None
    while first:
        first = first.next
        if n > 0:
            n -= 1
        else:
            prev = second
            second = second.next

    if second and second == node:
        node = node.next
    elif second:
        prev.next = second.next

    return node

root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)
root = remove_nth_from_end(root, 1)
print_list(root)


