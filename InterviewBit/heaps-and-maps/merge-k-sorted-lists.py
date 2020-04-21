import heapq

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param A : list of linked list
    # @return the head node in the linked list
    def mergeKLists(self, a):
        h = [(x.val, x.next) for x in a]
        heapq.heapify(h)

        head = tail = ListNode(None)
        while len(h) > 0:
            v, n = heapq.heappop(h)
            tail.next = ListNode(v)
            tail = tail.next
            if n:
                heapq.heappush(h, (n.val, n.next))
        return head.next
