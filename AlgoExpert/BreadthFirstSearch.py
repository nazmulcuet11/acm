# Do not edit the class below except
# for the breadthFirstSearch method.
# Feel free to add new properties
# and methods to the class.

import unittest
from queue import Queue


class Node:
    def __init__(self, name):
        self.children = []
        self.name = name

    def addChild(self, name):
        self.children.append(Node(name))
        return self

    def breadthFirstSearch(self, array):
        q = Queue()
        q.put(self)
        while not q.empty():
            t = q.get()
            array.append(t.name)
            for c in t.children:
                q.put(c)
        return array

class TestProgram(unittest.TestCase):
    def test_case_1(self):
        graph = Node("A")
        graph.addChild("B").addChild("C").addChild("D")
        graph.children[0].addChild("E").addChild("F")
        graph.children[2].addChild("G").addChild("H")
        graph.children[0].children[1].addChild("I").addChild("J")
        graph.children[2].children[0].addChild("K")
        self.assertEqual(graph.breadthFirstSearch([]), ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"])
        print("test 1: pass")


t = TestProgram()
t.test_case_1()
