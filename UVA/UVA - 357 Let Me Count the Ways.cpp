#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int coin_val[]= {1,5,10,25,50};
long long int dp[5][30005];
long long int coin_change(int i,int remaining)
{
    if(i==5)
    {
        if(remaining==0) return 1;
        return 0;
    }
    if(dp[i][remaining]!=-1) return dp[i][remaining];
    long long int ret1=0,ret2=0;
    if(remaining-coin_val[i]>=0)
        ret1=coin_change(i,remaining-coin_val[i]);
    ret2=coin_change(i+1,remaining);
    return dp[i][remaining]=ret1+ret2;
}
int main()
{
    memset(dp,-1,sizeof dp);
    int n;
    while(cin>>n)
    {
        long long int ans=coin_change(0,n);
        if(ans==1)
            cout<<"There is only 1 way to produce "<<n<<" cents change."<<endl;
        else
            cout<<"There are "<<ans<<" ways to produce "<<n<<" cents change."<<endl;
    }
    return 0;
}
