#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 30050

int main()
{
    map<ll, bool> mp;
    ll ans[SIZE];
    ll cnt = 1;
    for(int i = 1; i<= 300; i++)
    {
        for(int j = 1; j<=i; j++)
        {
            if(!mp[i*j])
            {
                mp[i*j] = true;
                cnt++;
            }
        }
        ans[i] = cnt;
    }

    printf("done\n");
    freopen("input.in", "r", stdin);
    ll testCase, n;
    scanf("%lld", &testCase);

    while(testCase--)
    {
        scanf("%lld", &n);
        printf("%lld\n", ans[n]);

    }
    return 0;
}
