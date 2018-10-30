#include <iostream>
#include <vector>
#include <cstdio>
#include <cstring>
#include <queue>

using namespace std;

vector<int> G[10000+5];
bool visited[10000+5];

int BFS(int source)
{
    if(visited[source])
        return 0;
    int count=0;
    queue<int>q;

    visited[source]=true;
    q.push(source);
    count++;
    while(!q.empty())
    {
        int u=q.front();
        q.pop();
        for(int i=0;i<G[u].size();i++)
        {
            if(!visited[G[u][i]])
            {
                visited[G[u][i]]=true;
                q.push(G[u][i]);
                count++;
            }
        }
    }
    return count;
}

int main()
{
    int test_case,n,m,l,u,v,source,sum;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        sum=0;
        scanf("%d %d %d",&n,&m,&l);
        for(int i=0;i<m;i++)
        {
            scanf("%d %d",&u,&v);
            G[u].push_back(v);
        }
        memset(visited,false,sizeof visited);
        for(int i=0;i<l;i++)
        {
            scanf("%d",&source);
            sum+=BFS(source);
        }
        printf("%d\n",sum);
        for(int i=0;i<10000+5;i++)
            G[i].clear();
    }
    return 0;
}
