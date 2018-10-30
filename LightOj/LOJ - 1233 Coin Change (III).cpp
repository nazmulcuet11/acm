#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;
bool dp[100005];
int coin[105],cnt[105],used[100005];
int main()
{
    int tc,n,m;
    scanf("%d",&tc);
    for(int c=1; c<=tc; c++)
    {
        scanf("%d %d",&n,&m);
        for(int i=0; i<n; i++)  scanf("%d",&coin[i]);
        for(int i=0; i<n; i++)  scanf("%d",&cnt[i]);
        for(int i=0; i<=m; i++) dp[i]=false;

        dp[0]=true;
        int count=0;
        for(int i=0; i<n; i++)
        {
            memset(used,0,sizeof used);
            for(int j=coin[i];j<=m;j++)
            {
                if(!dp[j]&&dp[j-coin[i]]&&used[j-coin[i]]<cnt[i])
                {
                    count++;
                    dp[j]=true;
                    used[j]=used[j-coin[i]]+1;
                }
            }
        }
        printf("Case %d: %d\n",c,count);
    }
    return 0;
}
