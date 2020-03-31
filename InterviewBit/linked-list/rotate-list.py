class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def lis_lenght(node):
    cnt = 0
    while node:
        node = node.next
        cnt += 1
    return cnt

def rotate_list(node, n):
    if not node:
        return node

    l = lis_lenght(node)
    n %= l
    if n < 1:
        return node

    nth = last = node
    prev = None
    while last.next:
        last = last.next
        if n > 1:
            n -= 1
        else:
            prev = nth
            nth = nth.next
    if prev:
        prev.next = None
        last.next = node

    return nth

root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)
root = rotate_list(root, 8)
print_list(root)