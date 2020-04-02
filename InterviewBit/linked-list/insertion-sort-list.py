class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def insertion_sort(node):
    if not node or not node.next:
        return node

    head  = tail = node
    runnig = node.next
    tail.next = None
    while runnig:
        t = runnig
        runnig = runnig.next

        curr = head
        prev = None
        while curr and curr.val <= t.val:
            prev = curr
            curr = curr.next

        if not curr: # We have a new tail
            tail.next = t
            tail = tail.next
            tail.next = None
        elif not prev: # We have a new head
            t.next = head
            head = t
        else:
            prev.next = t
            t.next = curr
    return head



root = ListNode(1, ListNode(3, ListNode(3)))
print_list(insertion_sort(root))
