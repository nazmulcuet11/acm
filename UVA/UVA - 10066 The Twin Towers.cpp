#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
int n1,n2,a1[101],a2[101];
int dp[102][102];
int lcs(int i,int j)
{
    if(i<0||j<0)
        return 0;
    if(dp[i][j]!=0)
        return dp[i][j];
    if(a1[i]==a2[j])
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
    while(cin>>n1>>n2&&(n1||n2))
    {
        memset(dp,0,sizeof dp);
        for(int i=0; i<n1; i++)
            cin>>a1[i];
        for(int i=0; i<n2; i++)
            cin>>a2[i];
        cout<<"Twin Towers #"<<c++<<endl;
        cout<<"Number of Tiles : "<<lcs(n1-1,n2-1)<<endl<<endl;
    }
    return 0;
}
