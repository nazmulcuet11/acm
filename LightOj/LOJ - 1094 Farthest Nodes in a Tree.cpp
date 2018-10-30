#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <cstring>
using namespace std;
vector<int>eadges[30005];
map <pair<int,int>,int>weight;
bool visited[30005];
int cost[30005],far_node;
int bfs(int start)
{
    int max_cosst=0;
    queue<int>q;
    q.push(start);
    visited[start]=true;
    cost[start]=0;
    while(!q.empty())
    {
        int t=q.front();
        q.pop();
        for(int i=0; i<eadges[t].size(); i++)
        {
            if(!visited[eadges[t][i]])
            {
                visited[eadges[t][i]]=true;
                q.push(eadges[t][i]);
                pair<int,int>x=make_pair(t,eadges[t][i]);
                cost[eadges[t][i]]=cost[t]+weight[x];
                if(max_cosst<cost[eadges[t][i]])
                {
                    max_cosst=cost[eadges[t][i]];
                    far_node=eadges[t][i];
                }
            }
        }
    }
    return max_cosst;
}
int main()
{
    int test_case,edg;
    cin>>test_case;
    for(int k=1; k<=test_case; k++)
    {
        memset(visited,false,sizeof visited);
        memset(cost,-1,sizeof cost);
        cin>>edg;
        for(int i=0; i<edg-1; i++)
        {
            int u,v,w;
            cin>>u>>v>>w;
            eadges[u].push_back(v);
            eadges[v].push_back(u);
            weight[make_pair(u,v)]=w;
            weight[make_pair(v,u)]=w;
        }
        bfs(0);
        memset(visited,false,sizeof visited);
        memset(cost,-1,sizeof cost);
        cout<<"Case "<<k<<": "<<bfs(far_node)<<endl;
        for(int i=0; i<30005; i++)
            eadges[i].clear();
        weight.clear();
    }
    return 0;
}
