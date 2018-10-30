#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define inf 1e9

ll testCase,caseNo = 1,m,n;
ll mat[15][105],dp[15][105],path[15][105];

ll solve(ll i,ll j)
{
    if(j>=n) return 0;

    if(dp[i][j]!=-1) return dp[i][j];

    ll ret1 = 0,ret2 = 0,ret3 = 0;

    ret1 = mat[i][j] + solve((i-1+m)%m,j+1);
    ret2 = mat[i][j] + solve(i%m,j+1);
    ret3 = mat[i][j] + solve((i+1)%m,j+1);

    ll mn = min(ret1,min(ret2,ret3));
    /*if(ret1==mn)
        path[i][j] = min(path[i][j],(i-1+m)%m);
    else if(ret2==mn)
        path[i][j] = min(path[i][j],(i)%m);
    else
        path[i][j] = min(path[i][j],(i+1+m)%m);*/

    return dp[i][j] = mn;
}

void printPath(ll i,ll j)
{
    if(j>=n) return;

    if(j+1==n)
        cout<<i+1<<"\n";
    else
        cout<<i+1<<" ";

    ll arr[3];
    arr[0] = (i-1+m)%m;
    arr[1] = i%m;
    arr[2] = (i+1)%m;

    sort(arr,arr+3);
    ll mn = min(dp[arr[0]][j+1],min(dp[arr[1]][j+1],dp[arr[2]][j+1]));

    if(dp[arr[0]][j+1]==mn)
        printPath(arr[0],j+1);
    else if(dp[arr[1]][j+1]==mn)
        printPath(arr[1],j+1);
    else
        printPath(arr[2],j+1);
}

int main()
{
    while(cin>>m>>n)
    {
        for(ll i=0;i<m;i++)
            for(ll j=0;j<n;j++)
                cin>>mat[i][j];

        memset(dp,-1,sizeof dp);
        memset(path,63,sizeof path);

        ll ans = inf,row;
        for(ll i=0;i<m;i++)
            if(ans>solve(i,0))
                ans=solve(i,0),row = i;

        printPath(row,0);
        cout<<ans<<"\n";
    }
    return 0;
}
