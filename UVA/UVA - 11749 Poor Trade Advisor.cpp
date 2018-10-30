#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>

typedef long long int LL;

using namespace std;

bool visited[500+5];
vector<LL> G[500+5];
vector<LL> cost[500+5];
vector<LL> node_list;
LL cnt,node,edge,u,v,w,max_ppa,ans;

LL BFS(LL source)
{
    queue<LL> q;
    LL cnt=0;
    for(int i=0;i<cost[source].size();i++)
    {
        if(cost[source][i]==max_ppa)
        {
            visited[source]=true;
            q.push(source);
            cnt++;
            break;
        }
    }

    while(!q.empty())
    {
        LL U=q.front();
        q.pop();
        for(LL i=0;i<G[U].size();i++)
        {
            LL V=G[U][i];
            //LL t=cost[U][i];
            if(!visited[V]&&cost[U][i]==max_ppa)
            {
                visited[V]=true;
                q.push(V);
                cnt++;
            }
        }
    }
    return cnt;
}

int main()
{
    while(scanf("%lld %lld",&node,&edge)&&(node||edge))
    {
        max_ppa = 2147483648;
        max_ppa = -max_ppa;
        memset(visited,false,sizeof visited);
        for(LL i=0;i<edge;i++)
        {
            scanf("%lld %lld %lld",&u,&v,&w);
            G[u].push_back(v);
            G[v].push_back(u);
            cost[u].push_back(w);
            cost[v].push_back(w);
            max_ppa=max(max_ppa,w);
            if(!visited[u])
                visited[u]=true,node_list.push_back(u);
            if(!visited[v])
                visited[v]=true,node_list.push_back(v);
        }
        memset(visited,false,sizeof visited);
        ans=0;

        for(int i=0;i<node_list.size();i++)
            if(!visited[node_list[i]])
                ans=max(ans,BFS(node_list[i]));
        printf("%lld\n",ans);

        for(int i=0;i<505;i++)
            G[i].clear(),cost[i].clear();
        node_list.clear();
    }
    return 0;
}
