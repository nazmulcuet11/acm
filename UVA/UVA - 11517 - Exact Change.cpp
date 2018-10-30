#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#define inf 9999
using namespace std;
int coin[101],n,make,test_case,sum,dp[1000005];
int coin_change()
{
    for(int i=0;i<1000005;i++) dp[i]=inf;
    dp[0]=0;
    int MAX=0;
    for(int i=0;i<n;i++)
    {
        for(int j=MAX;j>=0;j--)
        {
            if(dp[j]!=inf&&j+coin[i]<=sum)
            {
                dp[j+coin[i]]=min(dp[j+coin[i]],dp[j]+1);
                MAX=max(MAX,j+coin[i]);
            }
        }
    }
}
int main()
{
    scanf("%d",&test_case);
    while(test_case--)
    {
        cin>>make;
        cin>>n;
        sum=0;
        for(int i=0;i<n;i++)
        {
            scanf("%d",&coin[i]);
            sum+=coin[i];
        }
        coin_change();
        for(int i=make;i<=sum;i++)
        {
            if(dp[i]<inf)
            {
                cout<<i<<" "<<dp[i]<<endl;
                break;
            }
        }
    }
    return 0;
}
