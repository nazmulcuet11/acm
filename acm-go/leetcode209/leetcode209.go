package leetcode209

/*
// solution 1
// fix first index then binary search on second index
func minSubArrayLen(target int, nums []int) int {
	sums := make([]int, len(nums)+1)
	for i, v := range nums {
		sums[i+1] += sums[i] + v
	}

	minLen := len(sums)
	for i := 1; i < len(sums); i++ {
		b := i
		e := len(sums) - 1
		for b < e {
			m := (b + e) / 2
			if sums[m]-sums[i-1] >= target {
				e = m
			} else {
				b = m + 1
			}
		}
		if sums[b]-sums[i-1] >= target {
			minLen = min(b-i+1, minLen)
		}
	}
	if minLen == len(sums) {
		return 0
	}
	return minLen
}

// solution 2
// binary search on window size and run sliding window to check if a solution exisits for that window size
func minSubArrayLen(target int, nums []int) int {
	sums := make([]int, len(nums)+1)
	for i, v := range nums {
		sums[i+1] += sums[i] + v
	}

	if sums[len(sums)-1] < target {
		return 0
	}

	b := 0
	e := len(nums)
	for b < e {
		m := (b + e) / 2
		found := false
		for i := 0; i+m < len(sums); i++ {
			if sums[i+m]-sums[i] >= target {
				found = true
				break
			}
		}
		if found {
			e = m
		} else {
			b = m + 1
		}
	}
	return b
}
*/

// solution 3
// walk over the list, compute cumulative sums, optimize windwo lenght
func minSubArrayLen(target int, nums []int) int {
	sums := make([]int, len(nums)+1)
	ans := 0
	j := 0
	for i := 0; i < len(nums); i++ {
		sums[i+1] += sums[i] + nums[i]
		for sums[i+1]-sums[j] >= target {
			if ans == 0 || ans > i-j+1 {
				ans = i - j + 1
			}
			j++
		}
	}
	return ans
}
