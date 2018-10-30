#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int coin[]={1,5,10,25,50};
int make,dp[6][10000];

int coin_change(int i,int remain)
{
    if(i>=5)
    {
        if(remain==0)
        return 1;
        else
        return 0;
    }
    if(dp[i][remain]!=-1)
    return dp[i][remain];
    int ret1=0,ret2=0;
    if(remain-coin[i]>=0)
    ret1=coin_change(i,remain-coin[i]);
    ret2=coin_change(i+1,remain);
    return dp[i][remain]=ret1+ret2;
}

int main()
{
    memset(dp,-1,sizeof(dp));
    while(cin>>make)
    {
        cout<<coin_change(0,make)<<endl;
    }
    return 0;
}
