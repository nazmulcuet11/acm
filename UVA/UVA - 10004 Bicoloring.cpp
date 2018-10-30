#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
vector<int>eadges[1000];
bool visited[202];
int color[202];
void BFS()
{
    queue<int>q;
    bool flag=true;
    q.push(0);
    visited[0]=true;
    while(!q.empty()&&flag)
    {
        int t=q.front();
        q.pop();
        for(int i=0;i<eadges[t].size();i++)
        {
            if(!visited[eadges[t][i]])
            {
                visited[eadges[t][i]]=true;
                q.push(eadges[t][i]);
                if(color[t]==0)
                color[eadges[t][i]]=1;
                else
                color[eadges[t][i]]=0;
            }
            if(color[eadges[t][i]]==color[t])
            {
                flag=false;
                break;
            }
        }
    }
    if(flag)
    cout<<"BICOLORABLE."<<endl;
    else
    cout<<"NOT BICOLORABLE."<<endl;
}

int main()
{
    int n,l;
    while(cin>>n&&n)
    {
        memset(visited,false,sizeof visited);
        memset(color,0,sizeof color);
        cin>>l;
        for(int i=0; i<l; i++)
        {
            int u,v;
            cin>>u>>v;
            eadges[u].push_back(v);
            eadges[v].push_back(u);
        }
        BFS();
        for(int i=0; i<1000; i++)
            eadges[i].clear();
    }
}
