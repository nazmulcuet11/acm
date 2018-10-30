#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int map[30000+5],n,m,k;
bool visited[30000+5];
vector <int> G[30000+5],v;

int BFS(int source)
{
    memset(visited,false,sizeof visited);
    queue<int>q;
    visited[source]=true;
    q.push(source);
    v.push_back(source);
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
                v.push_back(G[u][i]);
            }
        }
    }
    return v.size();
}

void clear();

int main()
{
    //freopen("input.in","r",stdin);
    while(scanf("%d %d",&n,&m)&&(n||m))
    {
        for(int i=0;i<m;i++)
        {
            scanf("%d",&k);
            for(int j=0;j<k;j++)
                scanf("%d",&map[j]);
            for(int j=0;j<k;j++)
            {
                int u=map[j];
                for(int l=0;l<k;l++)
                {
                    if(map[l]!=u)
                        G[u].push_back(map[l]);
                }
            }
        }
        int ans=BFS(0);
        printf("%d\n",ans);
        clear();
    }
    return 0;
}

void clear()
{
    for(int i=0;i<30000+5;i++)
        G[i].clear();
    v.clear();
}
