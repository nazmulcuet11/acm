#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <algorithm>

using namespace std;

string str;
int dp[101][101];

int solve(int i,int j)
{
    if(i>=j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    if(str[i]==str[j])
        return dp[i][j]=solve(i+1,j-1);
    return dp[i][j]=1+min(solve(i+1,j),solve(i,j-1));
}

int main()
{
    int test_case,case_no=1,ans;

    for(scanf("%d",&test_case); test_case; test_case--)
    {
        cin>>str;
        memset(dp,-1,sizeof dp);
        ans=solve(0,str.size()-1);
        printf("Case %d: %d\n",case_no++,ans);
    }
    return 0;
}
