#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

struct edge
{
    int u,v,w;
};

bool comp1(edge a,edge b)
{
    return a.w<b.w;
}
bool comp2(edge a,edge b)
{
    return a.w>b.w;
}

vector <edge> edges;
int n,parent[101];

int set_parent()
{
    for(int i=0; i<101; i++)
        parent[i]=i;
}

int find_parent(int a)
{
    if(parent[a]==a) return a;
    return parent[a]=find_parent(parent[a]);
}

int MST_Kruskal()
{
    int sum=0;
    for(int i=0;i<edges.size();i++)
    {
        edge e=edges[i];
        int a=find_parent(e.u);
        int b=find_parent(e.v);
        if(a!=b)
        {
            sum+=e.w;
            parent[b]=a;
        }
    }
    return sum;
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case); test_case; test_case--)
    {
        edge e;
        scanf("%d",&n);
        while(scanf("%d %d %d",&e.u,&e.v,&e.w)&&(e.u||e.v||e.w))
        {
            edges.push_back(e);
        }
        set_parent();
        sort(edges.begin(),edges.end(),comp1);
        int minimum=MST_Kruskal();
        set_parent();
        sort(edges.begin(),edges.end(),comp2);
        int maximum=MST_Kruskal();
        printf("Case %d: ",case_no++);
        if((minimum+maximum)%2==0)
            printf("%d\n",(minimum+maximum)/2);
        else
            printf("%d/2\n",minimum+maximum);
        edges.clear();
    }
    return 0;
}
