#include <iostream>
#include <cstring>

using namespace std;

long long int dp[10001][10001];
long long int nCr(long long int n,long long int r)
{
    if(n==r||r==0)
    return 1;
    if(r==1)
    return n;
    if(dp[n][r]!=-1)
    return dp[n][r];
    return dp[n][r]=nCr(n-1,r)+nCr(n-1,r-1);
}
int main()
{
    long long int M,N,C;
    memset(dp,-1,sizeof(dp));
    while((cin>>N>>M)&&(M||N))
    {
        C=nCr(N,M);
        cout<<N<<" things taken "<<M<<" at a time is "<<C<<" exactly."<<endl;
    }
    return 0;
}
