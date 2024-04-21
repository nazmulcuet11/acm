package leetcode452

import "sort"

func hasOverlap(a []int, b []int) bool {
	if a[0] > b[0] {
		return hasOverlap(b, a)
	}

	return a[1] >= b[0]
}

func merged(a []int, b []int) []int {
	return []int{max(a[0], b[0]), min(a[1], b[1])}
}

func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] <= points[j][0]
	})

	mergedPoints := make([][]int, 0)
	for _, point := range points {
		n := len(mergedPoints)
		if n == 0 || !hasOverlap(mergedPoints[n-1], point) {
			mergedPoints = append(mergedPoints, point)
		} else {
			mergedPoints[n-1] = merged(mergedPoints[n-1], point)
		}
	}
	return len(mergedPoints)
}
