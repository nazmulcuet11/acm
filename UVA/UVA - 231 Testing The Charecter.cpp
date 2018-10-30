#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll testCase,caseNo=1,n,x,sz,dp[100000000];
vector<ll> v;

/*ll LIS(ll pos)
{
    if(dp[pos]!=-1) return dp[pos];

    ll ret = 0;
    for(ll i=pos+1;i<sz;i++)
        if(v[pos]>=v[i])
            ret = max(ret,LIS(i)+1);

    return dp[pos] = ret;
}*/

int main()
{
    while(scanf("%lld",&x)&&x!=-1)
    {
        v.clear();
        v.push_back(x);

        sz = 0;
        dp[sz++] = -1;

        while(scanf("%lld",&x)&&x!=-1)
            v.push_back(x),dp[sz++]=-1;


        ll ans = 0;
        //for(ll i=sz-1;i>=0;i--)
            //ans = max(ans,LIS(i)+1);

        for(ll i=sz-1;i>=0;i--)
        {
            dp[i] = 1;
            for(ll j=i+1;j<sz;j++)
            {
                if(v[i]>=v[j])
                {
                    dp[i] = max(dp[i],dp[j]+1);
                    //break;
                }
            }
            ans = max(ans,dp[i]);
        }

        if(caseNo>1)
            printf("\n");
        printf("Test #%lld:\n",caseNo++);
        printf("  maximum possible interceptions: %lld\n",ans);
    }
    return 0;
}
