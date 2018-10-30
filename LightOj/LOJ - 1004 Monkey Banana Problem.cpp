#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int mat[202][102],n;
int dp[202][102];
int move(int i,int j)
{
    if(i>=(2*n-1)||j>=n||j<0)
        return 0;
    if(dp[i][j]!=-1)
    return dp[i][j];

    int x=-100;
    x=max(x,(move(i+1,j)+mat[i][j]));
    x=max(x,(move(i+1,j-1)+mat[i][j]));
    x=max(x,(move(i+1,j+1)+mat[i][j]));
    return dp[i][j]=x;
}

int main()
{
    int testcase,c=1;
    cin>>testcase;
    while(testcase--)
    {
        memset(mat,0,sizeof(mat));
        memset(dp,-1,sizeof(dp));
        cin>>n;
        for(int i=0; i<n; i++)
            for(int j=0; j<=i; j++)
                cin>>mat[i][j];
        for(int i=n,k=n-1; i<2*n-1; i++,k--)
            for(int j=0; j<k; j++)
                cin>>mat[i][j];
        cout<<"Case "<<c++<<": "<<move(0,0)<<endl;
    }
    return 0;
}
