package leetcode12

func intToRoman(num int) string {
	entries := []struct {
		val    int
		symbol string
	}{
		{1000, "M"},
		{900, "CM"},
		{500, "D"},
		{400, "CD"},
		{100, "C"},
		{90, "XC"},
		{50, "L"},
		{40, "XL"},
		{10, "X"},
		{9, "IX"},
		{5, "V"},
		{4, "IV"},
		{1, "I"},
	}

	ans := ""
	i := 0
	for num > 0 {
		for entries[i].val > num {
			i++
		}
		q := num / entries[i].val

		for q > 0 {
			ans += entries[i].symbol
			q--
		}
		num %= entries[i].val
	}
	return ans
}
