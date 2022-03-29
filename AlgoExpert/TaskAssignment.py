def taskAssignment(k, tasks):
    tasksWithIndex = [t for t in enumerate(tasks)]
    tasksWithIndex.sort(key=lambda x: x[1])
    ans = []
    n = len(tasks)
    for i in range(k):
        ans.append([tasksWithIndex[i][0], tasksWithIndex[n-i-1][0]])
    return ans

k = 3
tasks = [1, 3, 5, 3, 1, 4]
print(taskAssignment(k, tasks))
