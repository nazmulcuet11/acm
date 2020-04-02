class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def list_len(node):
    cnt = 0
    while node:
        cnt += 1
        node = node.next
    return cnt

def reverse(node):
    prev = None
    while node:
        t = node
        node = node.next
        t.next = prev
        prev = t
    return prev

def cycle_starting(node):
    slow = fast = node
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            break
    
    if not fast or fast.next:
        return None
    
    slow = node
    while slow != fast:
        slow = slow.next
        fast = fast.next
    return fast

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the first node in the cycle in the linked list
    def detectCycle(self, A):
        return cycle_starting(A)

# root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
# print_list(root)

nodes = [ListNode(0)]
for i in range(1, 8):
    node = ListNode(i)
    nodes[i-1].next = node
    nodes.append(node)

# nodes[-1].next = nodes[2]
strt = cycle_starting(nodes[0])
if strt:
    print(strt.val)
else:
    print(None)
