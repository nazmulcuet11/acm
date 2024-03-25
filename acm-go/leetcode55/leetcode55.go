package leetcode55

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
