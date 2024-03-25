package leetcode55

/*
// iterative
func canJump(nums []int) bool {
	cache := make([]bool, len(nums))
	cache[0] = true
	for i, v := range nums {
		if cache[i] {
			for j := i; j <= i+v && j < len(nums); j++ {
				cache[j] = true
			}
		}
	}
	return cache[len(nums)-1]
}
*/

// recursive
func canJump(nums []int) bool {
	cache := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		cache[i] = -1
	}

	var solve func(int) int
	solve = func(i int) int {
		if i >= len(nums)-1 {
			return 1
		}

		if cache[i] != -1 {
			return cache[i]
		}

		cache[i] = 0
		for j := i + 1; j <= i+nums[i] && j < len(nums); j++ {
			cache[i] |= solve(j)
		}
		return cache[i]
	}

	return solve(0) == 1
}
