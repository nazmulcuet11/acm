#include <iostream>
#include <string>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

using namespace std;

int dp[1005][1005];
char a[1002],b[1002];

int rec(int i,int j)
{
    if(i<0||j<0)
        return 0;
    if(dp[i][j]!=-1)
        return dp[i][j];

    if(a[i]==b[j])
    {
        dp[i][j]=rec(i-1,j-1)+1;
        return dp[i][j];
    }

    else
    {
        int x=rec(i-1,j);
        int y=rec(i,j-1);
        dp[i][j]=max(x,y);
        return dp[i][j];
    }
}

int main()
{
    while(gets(a)&&gets(b))
    {
        if(strlen(a)==0||strlen(b)==0)
        {cout<<"0"<<endl;continue;}
        int l;
        memset(dp,-1,sizeof(dp));
        l=rec(strlen(a)-1,strlen(b)-1);
        cout<<l<<endl;
    }
    return 0;
}
