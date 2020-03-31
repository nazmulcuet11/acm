class Node:
    def __init__(self, x, next):
        self.val = x
        self.next = next

def print_list(root):
    while root:
        print("{} -> ".format(root.val), sep='->', end='')
        root = root.next
    print(None)

def remove_duplicate_two(node):
    root = prev = node
    while node:
        if prev.val == node.val:
            node = node.next
        else:
            allowed_cnt = 2
            while prev and prev != node and allowed_cnt > 1:
                prev = prev.next
                allowed_cnt -= 1
            if prev != node:
                prev.next = node
                prev = prev.next
    # last value is duplicated multiple times
    allowed_cnt = 2
    while prev and allowed_cnt > 1:
        prev = prev.next
        allowed_cnt -= 1
    prev.next = None
    return root

# def remove_duplicate(node):
#     prev = node
#     cnt = 0
#     root = tail = None
#     while node:
#         if prev.val == node.val:
#             node = node.next
#             cnt += 1
#         else:
#             # print(prev.val, cnt)
#             if cnt == 1:
#                 if tail:
#                     tail.next = prev
#                     tail = tail.next
#                 else:
#                     tail = root = prev
#             cnt = 0
#             prev = node

#     if cnt == 1:
#         if tail:
#             tail.next = prev
#             tail = tail.next
#         else:
#             tail = root = prev
#     if tail:
#         tail.next = None

#     return root

def remove_duplicate(node):
    cnt = 1
    root = tail = None
    while node:
        if node.next and node.val == node.next.val:
            cnt += 1
        elif cnt == 1:
            if tail:
                tail.next = node
                tail = tail.next
            else:
                tail = root = node
        else:
            cnt = 1
        node = node.next
    if tail:
        tail.next = None
    return root


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the head node in the linked list
    def deleteDuplicates(self, A):
        return remove_duplicate_two(A)

root = Node(1, Node(2, Node(3, Node(4, Node(4, None)))))
print_list(root)
root = Node(1, Node(1, Node(1, Node(2, Node(2, Node(2, Node(3, Node(4, Node(4, Node(4, Node(5, Node(5, Node(6, Node(7, Node(7, None)))))))))))))))
print_list(root)
root = remove_duplicate(root)
print_list(root)
root = Node(1, Node(1, Node(1, Node(2, Node(2, None)))))
print_list(root)
root = remove_duplicate(root)
print_list(root)
print_list(remove_duplicate(Node(1, None)))

