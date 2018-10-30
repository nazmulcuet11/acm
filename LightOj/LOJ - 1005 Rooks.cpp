#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

long long int dp[31][31][31];

long long int solve(int n,int m,int k)
{
    if(m<=0)
        return k==0?1:0;
    if(dp[n][m][k]!=-1) return dp[n][m][k];
    return dp[n][m][k]=n*solve(n-1,m-1,k-1)+solve(n,m-1,k);
}

int main()
{
    int test_case,case_no=1,N,K;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        memset(dp,-1,sizeof dp);
        scanf("%d %d",&N,&K);
        //long long int ans=N<K?0:solve(N,N,K);
        long long int ans=solve(N,N,K);
        printf("Case %d: %lld\n",case_no++,ans);
    }
    return 0;
}
