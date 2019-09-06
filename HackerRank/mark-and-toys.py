n, k = list(map(int, input().split()))
prices = sorted(list(map(int, input().split())))
count = 0
for price in prices:
    if k - price >= 0:
        k -= price
        count += 1
    else:
        break

print(count)