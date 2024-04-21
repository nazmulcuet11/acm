package leetcode57

func isLessThan(a []int, b []int) bool {
	return a[1] < b[0]
}

func hasOverlap(a []int, b []int) bool {
	if a[0] > b[0] {
		return hasOverlap(b, a)
	}

	return a[1] >= b[0]
}

func merged(a []int, b []int) []int {
	return []int{min(a[0], b[0]), max(a[1], b[1])}
}

func insert(intervals [][]int, newInterval []int) [][]int {
	ans := make([][]int, 0)
	i := 0
	n := len(intervals)

	for i < n && isLessThan(intervals[i], newInterval) {
		ans = append(ans, intervals[i])
		i++
	}

	for i < n && hasOverlap(newInterval, intervals[i]) {
		newInterval = merged(newInterval, intervals[i])
		i++
	}
	ans = append(ans, newInterval)

	for i < n {
		ans = append(ans, intervals[i])
		i++
	}

	return ans
}
