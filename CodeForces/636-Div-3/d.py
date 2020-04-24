for _ in range(int(input())):
    n, k = map(int, input().split())
    a = list(map(int, input().split()))

    cnt_zero = [0] * (2 * k + 5)
    cnt_zero_or_one = [0] * (2 * k + 5)
    i, j = 0, n-1
    while i < j:
        # Without changing any
        actual_sum = a[i] + a[j] 
        cnt_zero[actual_sum] += 1
        # Minimum sum by changing one, i.e keep the smaller and convert the bigger to 1
        min_sum = min(a[i], a[j]) + 1
        # Maximum sum by changing one, i.e keep the bigger and convert the smaller to k
        max_sum = max(a[i], a[j]) + k
        # We can create all possible sum form min to max using a[i] and a[j]
        cnt_zero_or_one[min_sum] += 1
        cnt_zero_or_one[max_sum + 1] -= 1 
        i += 1
        j -= 1
    
    for i in range(1, len(cnt_zero_or_one)):
        cnt_zero_or_one[i] += cnt_zero_or_one[i-1]
    
    ans = 2**31
    for x in range(2, len(cnt_zero_or_one)):
        cnt_one_only = cnt_zero_or_one[x] - cnt_zero[x]
        cnt_two = n / 2 - cnt_zero_or_one[x]
        ans = min(ans, cnt_one_only + cnt_two * 2)

    print(int(ans))