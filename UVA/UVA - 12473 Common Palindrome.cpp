#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>

using namespace std;

int dp[60][60][60][60];
string a,b;

int rec(int i,int j,int k,int l)
{
    if(i>j||k>l)
    return 0;
    if(dp[i][j][k][l]!=-1)
    return dp[i][j][k][l];
    if(a[i]==b[k]&&a[j]==b[l]&&a[i]==a[j])
    {
        if(i==j||k==l)
        dp[i][j][k][l]=rec(i+1,j-1,k+1,l-1)+1;
        else
        dp[i][j][k][l]=rec(i+1,j-1,k+1,l-1)+2;
        return dp[i][j][k][l];
    }
    else
    {
        int w=rec(i+1,j,k,l);
        int x=rec(i,j-1,k,l);
        int y=rec(i,j,k+1,l);
        int z=rec(i,j,k,l-1);
        dp[i][j][k][l]=max(max(w,x),max(y,z));
        return dp[i][j][k][l];
    }
}
int main()
{
    int t;
    cin>>t;
    for(int i=1;i<=t;i++)
    {
        memset(dp,-1,sizeof(dp));
        cin>>a>>b;
        cout<<"Case "<<i<<": "<<rec(0,a.size()-1,0,b.size()-1)<<endl;
    }
    return 0;
}
