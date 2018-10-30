#include <bits/stdc++.h>

#define SZ 100000+50

using namespace std;
typedef long long ll;

ll testCase,caseno = 1,n,outDegree[SZ],friendBottom[SZ],friendTop[SZ],u,v;
bool visited[SZ];
vector<ll>g[SZ];

void dfs(ll src)
{
    for(ll i=0;i<g[src].size();i++)
    {
        friendTop[g[src][i]] = friendTop[src]+1;
        dfs(g[src][i]);
    }
}

ll find_bottom(ll src)
{
    if(outDegree[src]==0) return friendBottom[src] = 0;

    for(ll i=0;i<g[src].size();i++)
        friendBottom[src]+=find_bottom(g[src][i])+1;

    return friendBottom[src];
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;

        memset(outDegree,0,sizeof outDegree);
        memset(friendBottom,0,sizeof friendBottom);
        memset(friendTop,0,sizeof friendTop);

        for(ll i=0;i<SZ;i++)
            g[i].clear();

        for(ll i=0;i<n-1;i++)
        {
            cin>>u>>v;
            outDegree[u]++;
            g[u].push_back(v);
        }

        dfs(1);
        find_bottom(1);

        ll ans = 0;
        for(ll i=1;i<=n;i++)
            ans+=n-(friendBottom[i]+friendTop[i]+1);

        cout<<"Case "<<caseno++<<": "<<n-1<<" "<<ans/2<<"\n";
    }
    return 0;
}
