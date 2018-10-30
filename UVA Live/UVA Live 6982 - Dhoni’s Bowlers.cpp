#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 100050

int main()
{
    int testCase;
    ll n, m, x , arr[SIZE], cs[SIZE];
    scanf("%d", &testCase);

    while(testCase--)
    {
        memset(cs, 0, sizeof cs);
        scanf("%lld %lld %lld", &n, &m, &x);

        for(int i = 0; i<n; i++)
        {
            scanf("%lld",&arr[i]);
            arr[i] %= m;
            cs[arr[i]]++;
        }

        for(int i = 1; i<m; i++)
            cs[i] += cs[i-1];

        ll sum = 0;
        for(int i = 0; i<n; i++)
        {
            if(arr[i]<=x)
                sum+=cs[x - arr[i]];
            ll l = m - arr[i];
            ll r = min(m-1, l+x);

            sum += (cs[r] - cs[l-1]);
        }

        printf("%lld\n", sum);
    }
    return 0;
}
