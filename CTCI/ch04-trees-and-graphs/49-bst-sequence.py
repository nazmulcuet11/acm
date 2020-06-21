from collections import deque

results = []
def weaveHelper(first, second, prefix):
    global results
    if len(first) == 0 or len(second) == 0:
        res = list(prefix) + list(first) + list(second)
        results.append(res)
        return
    
    prefix.append(first.popleft())
    weaveHelper(first, second, prefix)
    first.appendleft(prefix.pop())

    prefix.append(second.popleft())
    weaveHelper(first, second, prefix)
    second.appendleft(prefix.pop())

def weave(first, second):
    global results
    results = []
    weaveHelper(deque(first), deque(second), deque([]))
    print(results)

weave([1, 2], [3, 4])