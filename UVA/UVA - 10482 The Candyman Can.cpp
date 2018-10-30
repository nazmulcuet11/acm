///////////////////////////////
//UVA-10482- The candyman can//
///////////////////////////////
#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <cstdio>
using namespace std;
int test_case,n,arr[35],dp[35][645][645],total;
int knapsack(int index,int kid1,int kid2)
{
    if(index>=n)
    {
        int kid3=total-(kid1+kid2);
        int diff1=fabs(kid1-kid2);
        int diff2=fabs(kid1-kid3);
        int diff3=fabs(kid2-kid3);
        return dp[index][kid1][kid2]=max(diff1,max(diff2,diff3));
    }
    if(dp[index][kid1][kid2]!=-1) return dp[index][kid1][kid2];
    int x=knapsack(index+1,kid1,kid2);
    int y=knapsack(index+1,kid1+arr[index],kid2);
    int z=knapsack(index+1,kid1,kid2+arr[index]);
    return dp[index][kid1][kid2]=min(x,min(y,z));
}
int main()
{
    scanf("%d",&test_case);
    for(int case_no=1; case_no<=test_case; case_no++)
    {
        total=0;
        scanf("%d",&n);
        for(int i=0; i<n; i++)
        {

            scanf("%d",&arr[i]);
            total+=arr[i];
        }
        //memset(dp,-1,sizeof dp);
        for(int i=0;i<=n;i++)
            for(int j=0;j<645;j++)
                for(int k=0;k<645;k++)
                    dp[i][j][k]=-1;
        printf("Case %d: %d\n",case_no,knapsack(0,0,0));
    }
    return 0;
}
