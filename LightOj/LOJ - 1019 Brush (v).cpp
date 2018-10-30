#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

struct node
{
    int u,w;
    node(int a,int b)
    {
        u=a;
        w=b;
    }
    bool operator <(const node& p)const
    {
        return w > p.w;
    }
};

vector <int> G[105];
vector <int> cost[105];
bool visited[105];
int M,N,dist[105];

int DIJKSTRA(int source)
{
    memset(dist,-1,sizeof dist);
    priority_queue <node> pq;
    pq.push(node(1,0));
    dist[1]=0;
    while(!pq.empty())
    {
        node top=pq.top();
        pq.pop();
        int u=top.u;
        if(u==N) return dist[N];
        for(int i=0; i<G[u].size(); i++)
        {
            int v=G[u][i];
            if((dist[u]+cost[u][i]<dist[v])||dist[v]==-1)
            {
                dist[v]=dist[u]+cost[u][i];
                pq.push(node(v,dist[v]));
            }
        }
    }
    return -1;
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case); test_case; test_case--)
    {
        for(scanf("%d %d",&N,&M); M; M--)
        {
            int u,v,w;
            scanf("%d %d %d",&u,&v,&w);
            G[u].push_back(v);
            G[v].push_back(u);
            cost[u].push_back(w);
            cost[v].push_back(w);
        }
        int ans=DIJKSTRA(1);
        if(ans!=-1)
            printf("Case %d: %d\n",case_no++,ans);
        else
            printf("Case %d: Impossible\n",case_no++);
        for(int i=0; i<105; i++)
        {
            G[i].clear();
            cost[i].clear();
        }
    }
    return 0;
}
