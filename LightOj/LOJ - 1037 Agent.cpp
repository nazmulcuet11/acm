#include <bits/stdc++.h>
 
using namespace std;
typedef long long ll;
 
ll testCase,caseNo = 1,n,health[20],mx[20],arr[20][20];
 
ll dp[20][75000];
 
 
ll setBit(ll N,ll pos){return N = N|1<<pos;}
bool checkBit(ll N,ll pos){return N&1<<pos;}
 
bool allvisited(ll X)
{
    for(ll i=1;i<=n;i++)
        if(!checkBit(X,i))
            return false;
    return true;
}
 
ll bktk(ll x,ll mask)
{
    if(allvisited(mask))
        return 0;
 
    if(dp[x][mask]!=-1)
        return dp[x][mask];
 
    ll ret = 999999999;
    for(ll i=1;i<=n;i++)
    {
        if(!checkBit(mask,i))
        {
            ll tempArr[20];
            for(ll j=1;j<=n;j++)
            {
                tempArr[j] = mx[j];
                mx[j] = max(mx[j],arr[x][j]);
            }
 
            ll shotNeed = health[i]%mx[i]==0?health[i]/mx[i]:health[i]/mx[i]+1;
 
            ret = min(ret,bktk(i,setBit(mask,i))+shotNeed);
 
            for(ll j=1;j<=n;j++)
                mx[j] = tempArr[j];
        }
    }
    return dp[x][mask] = ret;
}
 
 
int main()
{
    //freopen("input.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        memset(dp,-1,sizeof dp);
        for(ll i=0;i<=n;i++)
            mx[i] = 1;
 
        for(ll i=1;i<=n;i++)
            cin>>health[i];
        for(ll i=1;i<=n;i++)
        {
            string str;
            cin>>str;
            for(ll j=0;j<str.size();j++)
                arr[i][j+1] = str[j]-'0';
        }
 
        cout<<"Case "<<caseNo++<<": "<<bktk(0,0)<<"\n";
    }
    return 0;
}