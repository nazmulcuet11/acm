package leetcode150

import (
	"strconv"
)

func isOperand(token string) bool {
	return token == "+" || token == "-" || token == "*" || token == "/"
}

func computeNewValue(a int, b int, operand string) int {
	if operand == "+" {
		return a + b
	} else if operand == "-" {
		return a - b
	} else if operand == "*" {
		return a * b
	} else if operand == "/" {
		return a / b
	} else {
		panic("invalid operation")
	}
}

func evalRPN(tokens []string) int {
	s := make([]int, 0)
	for _, t := range tokens {
		if isOperand(t) {
			n := len(s)
			newValue := computeNewValue(s[n-2], s[n-1], t)
			s = s[:n-2]
			s = append(s, newValue)
		} else {
			v, _ := strconv.Atoi(t)
			s = append(s, v)
		}
	}
	return s[0]
}
