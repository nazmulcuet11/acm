#include <iostream>
// #include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define MAX_N 2000050
ll m[MAX_N];
ll p[MAX_N];
ll cp[MAX_N];

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    ll test_case, n, k;
    scanf("%lld", &test_case);
    while(test_case--)
    {
        scanf("%lld %lld", &n, &k);
        for (int i = 0; i < n; i++)
        {
            ll x;
            scanf("%lld", &x);
            m[i] = x;
            p[i] = 0;
            cp[i] = 0;
        }
        
        for(int i = 1; i < n; i++) {
            if(i + 1 < n && m[i-1] < m[i] && m[i] > m[i+1]) {
                p[i] = 1;
            }
            cp[i] = cp[i-1] + p[i];
        }

        ll t = cp[k-1] + 1, l = 0;
        if(p[k-1] == 1) {
            t--;
        }
        // if(t > 0) {
        //     t++;
        // }
        for(int i = 1; i + k - 1 < n; i++) {
            ll x = cp[i + k - 1] - cp[i-1] + 1;
            if(p[i] == 1) {
                x--;
            }
            if(p[i + k - 1] == 1) {
                x--;
            }
            // if(x > 0) {
            //     x++;
            // }
            if(x > t) {
                t = x;
                l = i;
            }
        }
        printf("%lld %lld\n", t, l+1);
    }
    
    return 0;
}
