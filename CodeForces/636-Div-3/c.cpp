#include <iostream>
// #include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define MAX_N 200050


int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    int test_case;
    ll arr[MAX_N];
    scanf("%d", &test_case);
    while(test_case--)
    {
        ll n, x;
        scanf("%lld", &n);
        for(ll i = 0; i < n; i++) {
            scanf("%lld", &x);
            arr[i] = x;
        }

        ll i = 0, sum = 0;
        while(i < n)
        {
            ll sign = arr[i] > 0 ? 1: -1;
            ll mx = arr[i];
            while (i < n && arr[i] * sign > 0)
            {
                mx = max(arr[i], mx);
                i++;
            }
            sum += mx;
        }
        printf("%lld\n", sum);
    }
    return 0;
}
