import unittest


def getYoungestCommonAncestor(t, d1, d2):
    l1 = 0
    c1 = d1
    while c1 != t:
        l1 += 1
        c1 = c1.ancestor

    l2 = 0
    c2 = d2
    while c2 != t:
        l2 += 1
        c2 = c2.ancestor

    while l1 > l2:
        d1 = d1.ancestor
        l1 -= 1

    while l2 > l1:
        d2 = d2.ancestor
        l2 -= 1

    while d1 != d2:
        d1 = d1.ancestor
        d2 = d2.ancestor

    return d1


class AncestralTree():
    def __init__(self, name):
        self.name = name
        self.ancestor = None

    def addDescendants(self, *descendants):
        for descendant in descendants:
            descendant.ancestor = self


def new_trees():
    ancestralTrees = {}
    for letter in list("ABCDEFGHIJKLMNOPQRSTUVWXYZ"):
        ancestralTrees[letter] = AncestralTree(letter)
    return ancestralTrees


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        trees = new_trees()
        trees["A"].addDescendants(trees["B"], trees["C"])
        trees["B"].addDescendants(trees["D"], trees["E"])
        trees["D"].addDescendants(trees["H"], trees["I"])
        trees["C"].addDescendants(trees["F"], trees["G"])

        yca = getYoungestCommonAncestor(
            trees["A"], trees["E"], trees["I"])
        self.assertTrue(yca == trees["B"])


t = TestProgram()
t.test_case_1()
