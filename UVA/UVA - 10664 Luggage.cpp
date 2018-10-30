#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <vector>
#include <cmath>
using namespace std;
int dp[25][250],total;
vector<int>arr;
int knapsack(int i,int boot1)
{
    if(i>=arr.size()) return fabs((total-boot1)-boot1);
    if(dp[i][boot1]!=-1) return dp[i][boot1];
    int x=knapsack(i+1,boot1);
    int y=knapsack(i+1,boot1+arr[i]);
    return dp[i][boot1]=min(x,y);
}
int main()
{
    int test_case,n,count=0;
    char ch;
    scanf("%d",&test_case);
    while(count<test_case)
    {
        arr.clear();
        total=0;
        memset(dp,-1,sizeof dp);
        while(scanf("%d%c",&n,&ch)&&ch!='\n')
        {
            arr.push_back(n);
            total+=n;
        }
        arr.push_back(n);
        total+=n;
        count++;
        if(!knapsack(0,0))
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
    return 0;
}
