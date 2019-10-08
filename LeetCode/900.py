import collections

class Solution:
    def deckRevealedIncreasing(self, deck):
        ansDeck = [None] * len(deck)
        indices = collections.deque(range(len(deck)))
        for card in sorted(deck):
            ansDeck[indices.popleft()] = card
            if indices:
                indices.append(indices.popleft())

        return ansDeck

ans = Solution().deckRevealedIncreasing([17, 13, 11, 2, 3, 5, 7])
print(ans)