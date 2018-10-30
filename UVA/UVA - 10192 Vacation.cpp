#include <iostream>
#include <algorithm>
#include <cstring>
#include <cstdio>
using namespace std;
char mother[102],father[102];
int dp[102][102];
int lcs(int i,int j)
{
    if(i<0||j<0)
        return 0;
    if(dp[i][j]!=-1)
        return dp[i][j];
    if(mother[i]==father[j])
        return dp[i][j]=lcs(i-1,j-1)+1;
    else
    {
        int x=lcs(i-1,j);
        int y=lcs(i,j-1);
        return dp[i][j]=max(x,y);
    }
}
int main()
{
    int c=1;
    while(gets(mother)&&mother[0]!='#')
    {
        memset(dp,-1,sizeof dp);
        gets(father);
        printf("Case #%d: you can visit at most %d cities.\n",c++,lcs(strlen(mother)-1,strlen(father)-1));
    }
}
