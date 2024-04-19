package leetcode134

func canCompleteCircuit(gas []int, cost []int) int {
	i := 0
	n := len(gas)
	for i < n {
		j := i
		l := 0
		s := 0
		for l < n {
			s += gas[j%n]
			s -= cost[j%n]
			j++
			if s < 0 {
				break
			}
			l++
		}

		if l == n {
			return i
		}

		i = j
	}

	return -1
}
