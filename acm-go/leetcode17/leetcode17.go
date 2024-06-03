package leetcode17

import "fmt"

var digitToLetter = map[byte]string{
	'2': "abc",
	'3': "def",
	'4': "ghi",
	'5': "jkl",
	'6': "mno",
	'7': "pqrs",
	'8': "tuv",
	'9': "wxyz",
}

func solve(digits string, i int, cur []byte, ans *[]string) {
	if i == len(digits) {
		if len(cur) > 0 {
			*ans = append(*ans, string(cur))
		}
		return
	}

	digit := digits[i]
	bytes := digitToLetter[digit]
	for j := range len(bytes) {
		solve(digits, i+1, append(cur, bytes[j]), ans)
	}
}

func letterCombinations(digits string) []string {
	fmt.Println(digitToLetter)
	ans := make([]string, 0)
	solve(digits, 0, make([]byte, 0), &ans)
	return ans
}
