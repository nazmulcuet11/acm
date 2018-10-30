#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#define inf 999999
using namespace std;
int coin_val[6]= {5,10,20,50,100,200},arr[6],sales_man[550];
int dp[7][550];
void initialize();
int rec(int rem)
{
    if(rem<0) return inf;
    if(rem==0) return 0;
    if(sales_man[rem]!=inf) return sales_man[rem];
    for(int i=0;i<6;i++)
        sales_man[rem]=min(sales_man[rem],rec(rem-coin_val[i])+1);
    return sales_man[rem];
}
int coin_change(int i,int remaining)
{
    if(i>=6)
    {
        if(remaining==0) return 0;
        return inf;
    }
    if(dp[i][remaining]!=inf) return dp[i][remaining];
    int ret1=inf,ret2=inf;
    for(int j=1; j<=arr[i]; j++)
    {
        if(remaining-coin_val[i]*j>=0)
            ret1=min(ret1,coin_change(i+1,remaining-coin_val[i]*j)+j);
        else
            break;
    }
    ret2=coin_change(i+1,remaining);
    return dp[i][remaining]=min(ret1,ret2);
}
int main()
{
    for(int i=0;i<=550;i++) sales_man[i]=inf;
    rec(500);
    int a,b,n;
    while(1)
    {
        initialize();
        bool flag=false;
        for(int i=0; i<6; i++)
        {
            cin>>arr[i];
            if(arr[i])
                flag=true;
        }
        if(!flag) break;
        cin>>a;
        cin.ignore();
        cin>>b;
        n=a*100+b;
        int ans=coin_change(0,n);
        for(int i=n+1;i<=500;i++)
        {
            ans=min(ans,coin_change(0,i)+sales_man[i-n]);
        }
        printf("%3d\n",ans);
    }
    return 0;
}
void initialize()
{
    for(int i=0; i<7; i++)
        for(int j=0; j<550; j++)
            dp[i][j]=inf;
}
