#include <iostream>
// #include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(int argc, char const *argv[])
{
    // freopen("input.txt", "r", stdin);
    int test_case;
    scanf("%d", &test_case);
    while(test_case--)
    {
        ll n;
        scanf("%lld", &n);
        ll t = 2, sum = 1;
        while(sum <= n)
        {
            sum += t;
            if(n % sum == 0) {
                ll ans = n / sum;
                printf("%lld\n", ans);
                break;
            }
            t *= 2;
        }
    }
    return 0;
}
