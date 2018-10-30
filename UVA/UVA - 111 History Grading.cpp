#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int a[50],b[50];
int dp[50][50];
int lcs(int i,int j)
{
    if(i<1||j<1)
        return 0;
    if(dp[i][j]!=-1)
        return dp[i][j];
    if(a[i]==b[j])
        return dp[i][j]=lcs(i-1,j-1)+1;
    return dp[i][j]=max(lcs(i-1,j),lcs(i,j-1));
}
int main()
{
    int n,p;
    cin>>n;
    for(int i=1; i<=n; i++)
    {
        cin>>p;
        a[p]=i;
    }
    while(cin>>p)
    {
        memset(dp,-1,sizeof dp);
        b[p]=1;
        for(int i=2; i<=n; i++)
        {
            cin>>p;
            b[p]=i;
        }
        cout<<lcs(n,n)<<endl;
    }
    return 0;
}
