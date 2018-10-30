#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll testCase,caseNo = 1,k,n,m,u,v;

vector<ll>city_list,g[1000+50];
set<ll>all_lsit;

bool visited[1000+50];

void dfs(ll src)
{
    if(visited[src]) return;
    visited[src] = true;
    for(ll i=0;i<g[src].size();i++)
        dfs(g[src][i]);
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>k>>n>>m;
        for(ll i=0;i<k;i++)
        {
            cin>>u;
            city_list.push_back(u);
        }

        for(ll i=0;i<m;i++)
        {
            cin>>u>>v;
            all_lsit.insert(u);
            all_lsit.insert(v);
            g[v].push_back(u);
        }


        ll cnt = 0;
        for(ll i=1;i<=n;i++)
        {
            memset(visited,false,sizeof visited);
            dfs(i);

            ll is_ok = true;
            for(ll j=0;j<city_list.size()&&is_ok;j++)
                if(!visited[city_list[j]])
                    is_ok = false;

            if(is_ok)
                cnt++;
        }

        cout<<"Case "<<caseNo++<<": "<<cnt<<"\n";

        city_list.clear();
        for(ll i=0;i<1000+50;i++)
            g[i].clear();
    }
    return 0;
}
