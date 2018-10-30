#include <iostream>
#include <cstring>
#include <algorithm>
#include <cstdio>
#include <ctime>

using namespace std;

int coin[100],useable[100];
int make,dp[1003][1003],n;
int MOD=100000007;

int coin_change(int i,int remain)
{
    if(i>=n)
    {
        if(remain==0)
            return 1;
            return 0;
    }
    if(dp[i][remain]!=-1)
        return dp[i][remain];
    int ret=0;
    for(int taken_i=1; taken_i<=useable[i]; taken_i++)
    {
        if(remain-coin[i]*taken_i>=0)
            ret+=coin_change(i+1,remain-coin[i]*taken_i)%MOD;
        else
            break;
    }
    ret+=coin_change(i+1,remain)%MOD;
    return dp[i][remain]=ret%MOD;
}

int main()
{
    freopen("coin1.in", "r", stdin);
	freopen("coin1.ans", "w", stdout);
    double cl = clock();

    int testcase,c=1;
    cin>>testcase;
    while(testcase--)
    {
        memset(dp,-1,sizeof(dp));

        cin>>n>>make;
        for(int i=0; i<n; i++)
            cin>>coin[i];
        for(int i=0; i<n; i++)
            cin>>useable[i];
        cout<<"Case "<<c++<<": "<<coin_change(0,make)<<endl;
    }

    cl = clock() - cl;
	fprintf(stderr, "Total Execution Time = %lf seconds\n", cl / CLOCKS_PER_SEC);

    return 0;
}
