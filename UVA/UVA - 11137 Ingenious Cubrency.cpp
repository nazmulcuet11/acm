#include <iostream>
#include <cstring>

using namespace std;

int coin[21],make;
long long int dp[10000][10000];

long long int coin_change(int i,int remain)
{
    if(i>20)
    {
        if(remain==0)
        return 1;
        else
        return 0;
    }
    if(dp[i][remain]!=-1)
    return dp[i][remain];
    long long int ret1=0,ret2=0;
    if(remain-coin[i]>=0)
    ret1=coin_change(i,remain-coin[i]);
    ret2=coin_change(i+1,remain);
    return dp[i][remain]=ret1+ret2;
}

int main()
{
    for(int i=1;i<=21;i++)
    coin[i-1]=i*i*i;
    memset(dp,-1,sizeof(dp));
    while(cin>>make)
    {
        cout<<coin_change(0,make)<<endl;
    }
    return 0;
}
