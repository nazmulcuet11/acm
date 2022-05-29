def laptopRentals(times):
    values = []
    for time in times:
        values.append(time[0])
        values.append(time[1])

    values.sort()
    id = 0
    map = {}
    for value in values:
        if value not in map:
            map[value] = id
            id += 1
    
    t = [0 for _ in range(id)]
    for time in times:
        t[map[time[0]]] += 1
        t[map[time[1]]] -= 1

    mx = 0
    for i in range(len(1, t)):
        t[i] += t[i - 1]
        mx = max(mx, t[i])

    return mx
