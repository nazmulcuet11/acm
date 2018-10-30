#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <string.h>
#include <string>
#include <algorithm>

using namespace std;

vector<int>eadges[100];
vector<int>q;
int node,edg;
map<int,string>mp2;
bool first;
bool my_sort(int a,int b)
{
    return a>b;
}
void topological_sort(int *indegree)
{
    for(int i=1; i<=node; i++)
        if(indegree[i]==0)
            q.push_back(i);
    sort(q.begin(),q.end(),my_sort);
    while(!q.empty())
    {
        int t=q.back();
        q.pop_back();
        if(!first)
            cout<<" ";
        first=false;
        cout<<mp2[t];
        for(int i=0; i<eadges[t].size(); i++)
        {
            indegree[eadges[t][i]]--;
            if(indegree[eadges[t][i]]==0)
                q.push_back(eadges[t][i]);
            }
        sort(q.begin(),q.end(),my_sort);
    }
}

int main()
{
    int c=1;
    while(cin>>node)
    {
        int indegree[node+1];
        memset(indegree,0,sizeof indegree);
        map<string,int>mp;
        first=true;
        for(int i=1; i<=node; i++)
        {
            string n;
            cin>>n;
            mp[n]=i;
            mp2[i]=n;
        }
        cin>>edg;
        while(edg--)
        {
            string u,v;
            cin>>u>>v;
            eadges[mp[u]].push_back(mp[v]);
            indegree[mp[v]]++;
        }
        cout<<"Case #"<<c++<<": Dilbert should drink beverages in this order: ";
        topological_sort(indegree);
        cout<<"."<<endl<<endl;
        int i=100;
        while(i--)
            eadges[i].clear();
    }
}
