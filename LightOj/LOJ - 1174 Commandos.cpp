#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define inf 99999999

ll testCase,caseNo = 1,mp[105][105],n,e,u,v,strt,en;

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>e;
        for(ll i=0;i<n;i++)
            for(ll j=0;j<n;j++)
                mp[i][j] = inf,mp[i][i] = 0;

        for(ll i=0;i<e;i++)
        {
            cin>>u>>v;
            mp[u][v] = mp[v][u] = 1;
        }

        for(ll k=0;k<n;k++)
            for(ll i=0;i<n;i++)
                for(ll j=0;j<n;j++)
                    if(mp[i][j]>mp[i][k]+mp[k][j])
                        mp[i][j] = mp[i][k]+mp[k][j];

        cin>>strt>>en;

        ll ans = 0;
        for(ll i=0;i<n;i++)
            ans = max(ans,mp[strt][i]+mp[i][en]);

        cout<<"Case "<<caseNo++<<": "<<ans<<"\n";
    }
    return 0;
}