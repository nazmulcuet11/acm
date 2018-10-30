#include <iostream>
#include <stdio.h>
#include <string.h>
#include <algorithm>

using namespace std;

int house[1001],dp[1001],n,flag;
int optimum_sell(int i)
{
    if(i>=n)
        return 0;
    if(i==(n-1)&&flag)
        return 0;
    if(dp[i]!=-1)
        return dp[i];
    else
    {
        int x=optimum_sell(i+1);
        int y=house[i]+optimum_sell(i+2);
        dp[i]=max(y,x);
        return dp[i];
    }
}

int main()
{
    int t,c=0;
    cin>>t;
    while(t--)
    {
        cin>>n;
        for(int i=0; i<n; i++)
            cin>>house[i];
        memset(dp,-1,sizeof(dp));
        flag=0;
        int y=optimum_sell(1);
        memset(dp,-1,sizeof(dp));
        flag=1;
        int x=house[0]+optimum_sell(2);
        cout<<"Case "<<++c<<": "<<max(x,y)<<endl;
    }
    return 0;
}
