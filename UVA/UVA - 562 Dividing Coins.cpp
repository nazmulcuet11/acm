#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
int coin[105],m,dp[105][50050],total;
int knapsack(int i,int sum)
{
    if(i>=m) return fabs((total-sum)-sum);
    if(dp[i][sum]!=-1) return dp[i][sum];
    int x=knapsack(i+1,sum);
    int y=knapsack(i+1,sum+coin[i]);
    return dp[i][sum]=min(x,y);
}
int main()
{
    int test_case;
    cin>>test_case;
    while(test_case--)
    {
        cin>>m;
        total=0;
        for(int i=0;i<m;i++)
        {
            cin>>coin[i];
            total+=coin[i];
        }
        memset(dp,-1,sizeof dp);
        cout<<knapsack(0,0)<<endl;
    }
    return 0;
}
