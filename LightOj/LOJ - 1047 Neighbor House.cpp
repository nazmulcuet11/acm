#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define inf 9999999999

ll testCase,n,caseNo = 1,mat[25][4],dp[25][4];

ll rec(ll i,ll j)
{
    if(i>=n) return 0;

    if(dp[i][j]!=-1) return dp[i][j];

    ll ret = inf;
    for(ll k=1;k<=3;k++)
    {
        if(k==j) continue;
        ret = min(ret,mat[i+1][k]+rec(i+1,k));
    }
    return dp[i][j]=ret;
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        for(ll i=1;i<=n;i++)
            for(ll j=1;j<=3;j++)
                cin>>mat[i][j];

        memset(dp,-1,sizeof dp);
        cout<<"Case "<<caseNo++<<": "<<rec(0,0)<<"\n";
    }
    return 0;
}
