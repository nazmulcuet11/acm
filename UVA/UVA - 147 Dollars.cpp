#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
long long int dp[12][30005],arr[]= {10000,5000,2000,1000,500,200,100,50,20,10,5};
long long int coin_change(int i,long int remaining)
{
    if(i<0)
    {
        if(remaining==0) return 1;
        return 0;
    }
    if(dp[i][remaining]!=-1) return dp[i][remaining];
    long long int ret1=0,ret2=0;
    if(remaining-arr[i]>=0)
        ret1=coin_change(i,remaining-arr[i]);
    ret2=coin_change(i-1,remaining);
    return dp[i][remaining]=ret1+ret2;
}
int main()
{
    long int a,b;
    memset(dp,-1,sizeof dp);
    while(cin>>a&&cin.ignore()&&cin>>b&&(a||b))
    {
        long int n=a*100+b;
        printf("%6.2lf%17lld\n",n/100.00,coin_change(10,n));
    }
    return 0;
}
