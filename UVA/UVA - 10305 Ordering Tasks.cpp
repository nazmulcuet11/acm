#include <iostream>
#include <vector>
#include <string.h>
#include <queue>
#include <cstdio>

using namespace std;

int m,n;
vector<int>eadges[101];
int indegree[101];
bool first;

void topological_sort()
{
    queue<int>q;
    for(int i=1; i<=n; i++)
        if(!indegree[i])
            q.push(i);
    while(!q.empty())
    {
        if(!first)
        cout<<" ";
        first=false;
        int t=q.front();
        q.pop();
        cout<<t;
        for(int i=0; i<eadges[t].size(); i++)
        {
            indegree[eadges[t][i]]--;
            if(indegree[eadges[t][i]]==0)
                q.push(eadges[t][i]);
        }
    }
    return;
}

int main()
{
    while(cin>>n>>m&&(n||m))///Must be n||m cs n + holeo m o hote pare.
    {
        memset(indegree,0,sizeof indegree);
        first=true;
        for(int i=0; i<m; i++)
        {
            int a,b;
            cin>>a>>b;
            eadges[a].push_back(b);
            indegree[b]++;
        }
        topological_sort();
        cout<<endl;
        int i=101;
        while(i--)
        eadges[i].clear();
    }
    return 0;
}
