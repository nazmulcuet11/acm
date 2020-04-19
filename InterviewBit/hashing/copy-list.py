# Definition for singly-linked list with a random pointer.
class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        seen = {}
        curr = head
        while curr:
            seen[curr] = RandomListNode(curr.label)
            curr = curr.next

        new_head = new_curr = RandomListNode(None)
        curr = head
        while curr:
            t = seen[curr]
            if curr.next in seen:
                t.next = seen[curr.next]
            if curr.random in seen:
                t.random = seen[curr.random]
            curr = curr.next
            new_curr.next = t
            new_curr = new_curr.next
            
        return new_head.next