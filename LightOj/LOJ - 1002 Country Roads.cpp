#include <iostream>
#include <cstdio>
#include <queue>
#include <cstring>
#include <vector>
#include <algorithm>

#define inf 999999

using namespace std;

struct node{
    int city,W;
    bool operator < (const node &p) const { return W>p.W;}
};

vector<int>edges[501],cost[501];
int d[501];

void dijkstra(int source,int d[])
{
    priority_queue<node> q;
    node u,v;
    u.city=source;
    u.W=0;
    q.push(u);
    d[source]=0;
    while(!q.empty())
    {
       u=q.top();
       q.pop();
       int u_cost=d[u.city];///U te asar cost
       for(int i=0;i<edges[u.city].size();i++)
       {
           v.city=edges[u.city][i];
           v.W=cost[u.city][i];///U theke v te asar cost
           int res=min(d[v.city],max(u_cost,v.W));
           if(d[v.city]>res)
           {
               d[v.city]=res;
               q.push(v);
           }
       }
    }
}

int main()
{
    int test_case;
    scanf("%d",&test_case);
    for(int case_no=1;case_no<=test_case;case_no++)
    {
        int n,m;
        scanf("%d %d",&n,&m);
        for(int i=0;i<m;i++)
        {
            int u,v,w;
            scanf("%d %d %d",&u,&v,&w);
            edges[u].push_back(v);
            edges[v].push_back(u);
            cost[u].push_back(w);
            cost[v].push_back(w);
        }
        int source;
        scanf("%d",&source);
        for(int i=0;i<n;i++) d[i]=inf;
        dijkstra(source,d);
        printf("Case %d:\n",case_no);
        for(int i=0;i<n;i++)
        {
            if(d[i]==inf) printf("Impossible\n");
            else printf("%d\n",d[i]);
        }
        for(int i=0;i<501;i++)
        {
            edges[i].clear();
            cost[i].clear();
        }
    }
    return 0;
}
