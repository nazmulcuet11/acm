package leetcode148

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// copy below code

type LinkedList struct {
	head  *ListNode
	count int
}

func getLength(head *ListNode) int {
	count := 0
	for head != nil {
		count++
		head = head.Next
	}
	return count
}

func split(list LinkedList) (LinkedList, LinkedList) {
	curr := list.head
	c := 0
	for curr != nil && c < (list.count/2)-1 {
		c++
		curr = curr.Next
	}

	t := curr
	curr = curr.Next
	c++
	t.Next = nil

	left := LinkedList{list.head, c}
	right := LinkedList{curr, list.count - c}

	return left, right
}

func merge(left LinkedList, right LinkedList) LinkedList {
	// fmt.Println("left: ", getVals(left))
	// fmt.Println("right: ", getVals(right))

	if left.head == nil {
		return right
	}
	if right.head == nil {
		return left
	}

	var mergedHead *ListNode
	var currMerged *ListNode

	currLeft := left.head
	currRight := right.head

	for currLeft != nil && currRight != nil {
		var t *ListNode
		if currLeft.Val < currRight.Val {
			t = currLeft
			currLeft = currLeft.Next
		} else {
			t = currRight
			currRight = currRight.Next
		}

		t.Next = nil
		if mergedHead == nil {
			mergedHead = t
		} else {
			currMerged.Next = t
		}
		currMerged = t
	}

	if currLeft != nil {
		if mergedHead == nil {
			mergedHead = currLeft
		} else {
			currMerged.Next = currLeft
		}

	} else if currRight != nil {
		if mergedHead == nil {
			mergedHead = currRight
		} else {
			currMerged.Next = currRight
		}
	}

	mergedList := LinkedList{mergedHead, left.count + right.count}
	// fmt.Println("merged: ", getVals(mergedList))
	// fmt.Println("----------------------")
	return mergedList
}

func mergeSort(list LinkedList) LinkedList {
	if list.count <= 1 {
		return list
	}

	left, right := split(list)
	// fmt.Println("after split left: ", getVals(left))
	// fmt.Println("after split right: ", getVals(right))
	left = mergeSort(left)
	right = mergeSort(right)
	// fmt.Println("after sort left: ", getVals(left))
	// fmt.Println("after sort right: ", getVals(right))
	merged := merge(left, right)
	// fmt.Println("after merge merged: ", getVals(merged))
	// fmt.Println("----------------------")
	return merged
}

// func getVals(list LinkedList) []int {
// 	head := list.head
// 	vals := make([]int, 0)
// 	for head != nil {
// 		vals = append(vals, head.Val)
// 		head = head.Next
// 	}
// 	return vals
// }

func sortList(head *ListNode) *ListNode {
	// nodes := getNodes(head)
	// sort.Slice(nodes[:], func(i, j int) bool {
	//     return nodes[i].Val < nodes[j].Val
	// })
	// return joinNodes(nodes)
	sortedList := mergeSort(LinkedList{head, getLength(head)})
	return sortedList.head
}
