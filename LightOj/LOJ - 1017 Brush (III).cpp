#include <cstdio>
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int N,W,K,dp[101][101];
long long int points[101];

int solve(int pos,int move)
{
    if(pos>=N||move>=K) return 0;
    if(dp[pos][move]!=-1) return dp[pos][move];
    int ret1=0,ret2=0,i;
    for( i=pos;i<N&&points[i]<=points[pos]+W;i++)
        ret1++;
    ret1+=solve(i,move+1);
    ret2=solve(pos+1,move);
    return dp[pos][move]=max(ret1,ret2);
}

int main()
{
    int test_case,case_no=1,x;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d %d %d",&N,&W,&K);
        for(int i=0;i<N;i++)
            scanf("%d %lld",&x,&points[i]);
        sort(points,points+N);
        memset(dp,-1,sizeof dp);
        printf("Case %d: %d\n",case_no++,solve(0,0));
    }
    return 0;
}
