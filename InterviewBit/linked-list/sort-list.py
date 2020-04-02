class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def merge(A, B):
    root = tail = ListNode(None)
    while A and B:
        if A.val < B.val:
            tail.next = ListNode(A.val)
            A = A.next
        else:
            tail.next = ListNode(B.val)
            B = B.next
        tail = tail.next
    while A:
        tail.next = ListNode(A.val)
        A = A.next
        tail = tail.next
    while B:
        tail.next = ListNode(B.val)
        B = B.next
        tail = tail.next
    return root.next

def split(node):
    if not node:
        return (None, None)

    if not node.next:
        return (node, None)

    slow = root = node
    fast = node.next
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    t = slow
    slow = slow.next
    t.next = None
    return (root, slow)

def merge_sort(node):
    if not node:
        return node
    left, right = split(node)
    left = merge_sort(left)
    right = merge_sort(right)
    return merge(left, right)

def list_len(node):
    cnt = 0
    while node:
        cnt += 1
        node = node.next
    return cnt

def chunk(node, k):
    count = k
    prev = None
    curr = node
    while curr and count:
        prev = curr
        curr = curr.next
        count -= 1
    if prev:
        prev.next = None
    return (node, curr)

def tail(node):
    while node.next:
        node = node.next
    return node

def merge_sort_iterative(node):
    l = list_len(node)
    root = node
    gap = 1
    while gap <= l:
        prev_tail = None
        curr = root
        while curr:
            left, curr = chunk(curr, gap)
            right, curr = chunk(curr, gap)

            merged_head = merge(left, right)
            merged_tail = tail(merged_head)

            if not prev_tail:
                root = merged_head
                prev_tail = merged_tail
            else:
                prev_tail.next = merged_head
                prev_tail = merged_tail
        gap *= 2

    return root




root = ListNode(15, ListNode(10, ListNode(5, ListNode(20, ListNode(3, ListNode(2, ListNode(6, ListNode(8, ListNode(9)))))))))
print_list(merge_sort_iterative(root))

