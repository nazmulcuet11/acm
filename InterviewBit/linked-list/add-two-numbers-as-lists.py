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

def add(num_one, num_two):
    len_one = list_len(num_one)
    len_two = list_len(num_two)

    while len_one < len_two:
        t = ListNode(0)
        t.next = num_one
        num_one = t
        len_one += 1
    
    while len_two < len_one:
        t = ListNode(0)
        t.next = num_two
        num_two = t
        len_two += 1

    num_one = reverse(num_one)
    num_two = reverse(num_two)

    carry = 0
    head = num_one
    tail = None
    while num_one:
        sum = num_one.val + num_two.val + carry
        num_one.val = sum % 10
        carry = sum // 10
        tail = num_one
        num_one = num_one.next
        num_two = num_two.next
    
    if carry:
        tail.next = ListNode(carry)
    
    num_one = reverse(head)
    while num_one and num_one.val == 0:
        num_one = num_one.next
    return num_one

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @param B : head node of linked list
    # @return the head node in the linked list
    def addTwoNumbers(self, A, B):
        A = reverse(A)
        B = reverse(B)
        C = add(A, B)
        return reverse(C)


root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
print_list(root)

a = ListNode(1, ListNode(2, ListNode(3)))
b = ListNode(2, ListNode(2))
a = add(a, b)
print_list(a)