package leetcode274

import (
	"sort"
)

func hIndex(citations []int) int {
	sort.Sort(sort.Reverse(sort.IntSlice(citations)))
	mx := 0
	for i := 0; i < len(citations); i++ {
		mx = max(mx, min(i+1, citations[i]))
	}
	return mx
}
