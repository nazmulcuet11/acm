package leetcode92

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	var lTail, mHead, mTail *ListNode
	curr := head
	count := 0
	for curr != nil && count < right {
		count++
		t := curr
		curr = curr.Next
		if count == left-1 {
			lTail = t
			lTail.Next = nil
		} else if count == left {
			mHead = t
			mTail = t
			mTail.Next = nil
		} else if count > left {
			t.Next = mHead
			mHead = t
		}
	}

	if lTail != nil {
		lTail.Next = mHead
	}
	if mTail != nil {
		mTail.Next = curr
	}

	if lTail != nil {
		return head
	} else {
		return mHead
	}
}
