class LinkedListNode:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


class LinkedList:
    def __init__(self):
        self.count = 0
        self.head = None
        self.tail = None

    def append(self, value):
        node = LinkedListNode(value)
        if self.tail:
            node.prev = self.tail
            self.tail.next = node
            self.tail = self.tail.next
        else:
            self.head = self.tail = node
        self.count += 1
        return node

    def prepend(self, value):
        node = LinkedListNode(value)
        if self.head:
            node.next = self.head
            self.head.prev = node
            self.head = self.head.prev
        else:
            self.head = self.tail = node
        self.count += 1
        return node

    def remove(self, node):
        if node == self.head:
            if self.head.next:
                self.head = self.head.next
                self.head.prev = None
                node.next = None
            else:
                self.head = self.tail = None
        elif node == self.tail:
            if self.tail.prev:
                self.tail = self.tail.prev
                self.tail.next = None
                node.prev = None
            else:
                self.head = self.tail = None
        else:
            prev = node.prev
            next = node.next
            prev.next = next
            next.prev = prev
            node.prev = None
            node.next = None
        self.count -= 1

    def __repr__(self):
        head = self.head
        desc = ""
        while head:
            if len(desc) > 0:
                desc += " -> "
            desc += str(head.value)
            head = head.next
        return desc


class LRUCache:
    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.key_to_list_node = {}
        self.key_value_list = LinkedList()

    def move_node_to_last(self, node):
        key, value = node.value
        self.key_value_list.remove(node)
        new_node = self.key_value_list.append((key, value))
        self.key_to_list_node[key] = new_node

    # @param key, an integer
    # @return an integer
    def get(self, key):
        if key in self.key_to_list_node:
            node = self.key_to_list_node[key]
            k, v = node.value
            self.move_node_to_last(node)
            return v
        else:
            return -1

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.key_to_list_node:
            node = self.key_to_list_node[key]
            node.value = (key, value)
            self.move_node_to_last(node)
        else:
            node = self.key_value_list.append((key, value))
            self.key_to_list_node[key] = node

        if self.key_value_list.count > self.capacity:
            node = self.key_value_list.head
            k, v = node.value
            if k in self.key_to_list_node:
                del self.key_to_list_node[k]
            self.key_value_list.remove(node)

    def __repr__(self):
        return self.key_value_list.__repr__()


cache = LRUCache(5)
cache.set('A', 1)
print(cache)
cache.set('B', 2)
print(cache)
cache.set('C', 3)
print(cache)
cache.set('D', 4)
print(cache)
cache.set('E', 5)
print(cache)
cache.set('F', 6)
print(cache)
cache.set('G', 7)
print(cache)
cache.set('C', 9)
print(cache)
