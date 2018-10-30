#include <stdio.h>
#include <string.h>
const int mod = 100000007;
int dp[10005];
int coin[105];
int main()
{
    int t, n, k;
    scanf("%d", &t);
    for (int tc = 1; tc <= t; tc++)
    {
        scanf("%d %d", &n, &k);
        for (int i = 1; i <= n; i++)
        {
            scanf("%d", &coin[i]);
        }
        for(int i=0;i<=k;i++) dp[i]=0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = coin[i]; j <= k; j++)
            {
                    dp[j]+= dp[j-coin[i]];
                    dp[j]%=mod;
            }
        }
        printf("Case %d: %d\n", tc, dp[k]);
    }
    return 0;
}
