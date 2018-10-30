#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

vector <int> adj[20000+5],lycan,vampire,node_list;
int color[20000+5];
bool visited[20000+5];

int BFS(int source)
{
    vampire.clear();
    lycan.clear();
    queue <int> q;
    q.push(source);
    color[source]=0;
    vampire.push_back(source);
    visited[source]=true;
    while(!q.empty())
    {
        int t=q.front();
        q.pop();
        for(int i=0;i<adj[t].size();i++)
        {
            if(!visited[adj[t][i]])
            {
                visited[adj[t][i]]=true;
                q.push(adj[t][i]);
                if(color[t]==0)
                {
                    color[adj[t][i]]=1;
                    lycan.push_back(adj[t][i]);
                }
                else if(color[t]==1)
                {
                    color[adj[t][i]]=0;
                    vampire.push_back(adj[t][i]);
                }
            }
        }
    }
    return max(vampire.size(),lycan.size());
}

int main()
{
    int test_case,case_no=1,n,u,v,source;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        memset(visited,false,sizeof visited);
        for(scanf("%d",&n);n;n--)
        {
            scanf("%d %d",&u,&v);
            if(!visited[u]){ node_list.push_back(u);visited[u]=true;}
            if(!visited[v]){ node_list.push_back(v);visited[v]=true;}
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        memset(visited,false, sizeof visited);
        int ans=0;
        for(int i=0;i<node_list.size();i++)
        {
            if(!visited[node_list[i]])
                ans+=BFS(node_list[i]);
        }
        printf("Case %d: %d\n",case_no++,ans);
        vampire.clear();
        lycan.clear();
        node_list.clear();
        for(int i=0;i<20005;i++) adj[i].clear();
    }
    return 0;
}
