#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstring>
#include <vector>
using namespace std;
int n,x;
int arr[105],target,per;
double dp[105][10005];
double knapsack(int i,int sum)
{
    if(i>=n-1)
    {
        if(sum>5000)
        {
            double ret=target*100;
            ret=ret/sum;
            return ret;
        }
        return target/100;
    }
    if(dp[i][sum]!=-1.00) return dp[i][sum];
    double x=knapsack(i+1,sum);
    double y=knapsack(i+1,sum+arr[i]);
    return dp[i][sum]=max(x,y);
}
int main()
{
    while(scanf("%d %d",&n,&x)&&n&&x)
    {
        for(int i=0,j=0; i<n; i++)
        {
            int a,b;
            cin>>a;cin.ignore();cin>>b;
            per=a*100+b;
            if(i==x-1)
                target=per;
            else
            {
                arr[j++]=per;
            }
        }
        for(int i=0;i<=n;i++)
            for(int j=0;j<10005;j++)
                dp[i][j]=-1.00;
        printf("%0.2lf\n",knapsack(0,target));
    }
    return 0;
}
