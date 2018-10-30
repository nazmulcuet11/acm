#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll testCase,caseNo = 1,dp[65][65];

string str;

ll rec(ll i,ll j)
{
    if(i>j) return 0;

    if(dp[i][j]!=-1) return dp[i][j];

    ll ret = 0;
    if(str[i]==str[j])
        ret = 1+rec(i,j-1)+rec(i+1,j);
    else
        ret = rec(i,j-1)+rec(i+1,j)-rec(i+1,j-1);
    return dp[i][j] = ret;
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>str;
        memset(dp,-1,sizeof dp);
        cout<<"Case "<<caseNo++<<": "<<rec(0,str.size()-1)<<"\n";
    }
    return 0;
}
