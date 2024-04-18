package leetcode380

import "math/rand"

type RandomizedSet struct {
	values         []int
	valueToIndices map[int]int
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		values:         make([]int, 0),
		valueToIndices: make(map[int]int),
	}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.valueToIndices[val]; ok {
		// value already exists
		return false
	}

	this.valueToIndices[val] = len(this.values)
	this.values = append(this.values, val)
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	index, ok := this.valueToIndices[val]
	if !ok {
		// value does not exists
		return false
	}

	if len(this.values) > 1 && index != len(this.values)-1 {
		// swap with the last element and delete the last element
		lastValue := this.values[len(this.values)-1]
		this.values[index] = lastValue
		this.valueToIndices[lastValue] = index
	}
	// delete last element
	this.values = this.values[:len(this.values)-1]
	delete(this.valueToIndices, val)
	return true
}

func (this *RandomizedSet) GetRandom() int {
	index := rand.Intn(len(this.values))
	return this.values[index]
}
