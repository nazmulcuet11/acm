package leetcode211

type TrieNode struct {
	children map[rune]*TrieNode
	isEnding bool
}

func CreateTrieNode() *TrieNode {
	return &TrieNode{
		children: make(map[rune]*TrieNode),
		isEnding: false,
	}
}

type WordDictionary struct {
	head *TrieNode
}

func Constructor() WordDictionary {
	return WordDictionary{CreateTrieNode()}
}

func (d *WordDictionary) AddWord(word string) {
	curr := d.head
	for _, c := range word {
		_, ok := curr.children[c]
		if !ok {
			curr.children[c] = CreateTrieNode()
		}
		curr = curr.children[c]
	}
	curr.isEnding = true
}

func (d *WordDictionary) Search(word string) bool {
	return SearchHeleper(d.head, 0, word)
}

func SearchHeleper(node *TrieNode, i int, word string) bool {
	if i == len(word) {
		return node != nil && node.isEnding
	}

	c := rune(word[i])
	if c == '.' {
		ans := false
		for _, child := range node.children {
			ans = ans || SearchHeleper(child, i+1, word)
		}
		return ans
	} else {
		_, ok := node.children[c]
		if !ok {
			return false
		}
		return SearchHeleper(node.children[c], i+1, word)
	}
}
