# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param A : head node of linked list
    # @param B : head node of linked list
    # @return the head node in the linked list
    def mergeTwoLists(self, A, B):
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