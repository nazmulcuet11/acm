#include <bits/stdc++.h>

using namespace std;

#define SZ 105

bool visited[SZ];

/**BFS functions return true if there is an augmented path between source and sink
   returns false otherwise.*/
bool BFS(int rGraph[SZ][SZ],int source,int sink,int *parent)
{

    memset(visited,false,sizeof visited);

    queue<int>q;
    q.push(source);
    visited[source] = true;
    parent[source] = -1;

    while(!q.empty())
    {
        int u = q.front();
        q.pop();

        for(int v = 0; v<SZ; v++)
        {
            if(!visited[v] && rGraph[u][v]>0)
            {
                q.push(v);
                visited[v] = true;
                parent[v] = u;
            }
        }
    }

    return visited[sink];
}

int fordFulkerson(int graph[SZ][SZ],int source,int sink)
{
    int u,v;
    int rGraph[SZ][SZ]; /**Residual graph*/

    for(int i = 0; i<SZ; i++)
        for(int j = 0; j<SZ; j++)
            rGraph[i][j] = graph[i][j];

    int parent[SZ];

    int maximumFlow = 0;

    while(BFS(rGraph,source,sink,parent))
    {
        /** Find minimum residual capacity of the edges along the path found by BFS.**/
        int pathFlow = INT_MAX;

        for(v = sink; v!=source; v = parent[v])
        {
            u = parent[v];
            pathFlow = min(pathFlow,rGraph[u][v]);
        }
        /** Update residual capacities along the edges and reverse the edges along the path**/
        for(v = sink; v!=source; v = parent[v])
        {
            u = parent[v];
            rGraph[u][v] -= pathFlow;
            rGraph[v][u] += pathFlow;
        }

        /**Add the current path's flow to maximum flow*/
        maximumFlow += pathFlow;
    }

    return maximumFlow;
}

int testCase,caseNo = 1;

int main()
{
    int graph[SZ][SZ],noOfVertices;
    scanf("%d",&testCase);
    while(testCase--)
    {
        memset(graph,0,sizeof graph);
        int source,sink,c;
        scanf("%d",&noOfVertices);
        scanf("%d %d %d",&source,&sink,&c);

        for(int i = 0; i<c; i++)
        {
            int u,v,w;
            scanf("%d %d %d",&u,&v,&w);
            graph[u][v] += w;
            graph[v][u] += w;
        }

        printf("Case %d: %d\n",caseNo++,fordFulkerson(graph,source,sink));
    }
    return 0;
}
