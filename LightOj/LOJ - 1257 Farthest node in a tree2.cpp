#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <cstring>
#include <algorithm>
#include <cstdio>
using namespace std;
vector<pair<int,int> >eadges[30005];
int cost[30005],result[30005],far_node,max_cost;
void bfs(int start)
{
    memset(cost,-1,sizeof cost);
    queue<int>q;
    q.push(start);
    cost[start]=0;
    max_cost=0;
    while(!q.empty())
    {
        int t=q.front();
        q.pop();
        for(int i=0;i<eadges[t].size();i++)
        {
            int x=eadges[t][i].first;
            int y=eadges[t][i].second;
            if(cost[x]==-1)
            {
                cost[x]=cost[t]+y;
                result[x]=max(cost[x],result[x]);
                q.push(x);
                if(max_cost<cost[x])
                {
                    max_cost=cost[x];
                    far_node=x;
                }
            }
        }
    }
    return;
}
int main()
{
    int test_case,node;
    scanf("%d",&test_case);
    for(int i=1;i<=test_case;i++)
    {
        cin>>node;
        for(int j=0;j<node-1;j++)
        {
            int u,v,w;
            scanf("%d%d%d",&u,&v,&w);
            eadges[u].push_back(make_pair(v,w));
            eadges[v].push_back(make_pair(u,w));
        }
        bfs(0);
        memset(result,-1,sizeof result);
        bfs(far_node);
        bfs(far_node);
        printf("Case %d:\n",i);
        for(int i=0;i<node;i++)
        {
            printf("%d\n",result[i]);
            eadges[i].clear();
        }
    }
}
