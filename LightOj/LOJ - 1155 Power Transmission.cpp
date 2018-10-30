#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SZ 210

bool visited[SZ];
ll nodeCapacity[SZ];

/**BFS functions return true if there is an augmented path between source and sink
   returns false otherwise.*/
bool BFS(ll rGraph[SZ][SZ],ll source,ll sink,ll *parent)
{

    memset(visited,false,sizeof visited);

    queue<ll>q;
    q.push(source);
    visited[source] = true;
    parent[source] = -1;

    while(!q.empty())
    {
        ll u = q.front();
        q.pop();

        for(ll v = 0; v<SZ; v++)
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

ll fordFulkerson(ll graph[SZ][SZ],ll source,ll sink)
{
    ll u,v;
    ll rGraph[SZ][SZ]; /**Residual graph*/

    for(ll i = 0; i<SZ; i++)
        for(ll j = 0; j<SZ; j++)
            rGraph[i][j] = graph[i][j];

    ll parent[SZ];

    ll maximumFlow = 0;

    while(BFS(rGraph,source,sink,parent))
    {
        /** Find minimum residual capacity of the edges along the path found by BFS.**/
        ll pathFlow = INT_MAX;

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

ll testCase,caseNo = 1;

int main()
{
    ll graph[SZ][SZ],noOfVertices,auxilary;
    scanf("%lld",&testCase);
    while(testCase--)
    {
        memset(graph,0,sizeof graph);
        for(int i=0; i<SZ; i++)
            nodeCapacity[i] = 10000;

        ll source,sink,c,B,D;
        scanf("%lld",&noOfVertices);

        for(ll i = 1; i<=noOfVertices; i++)
            scanf("%lld",&nodeCapacity[i]);

        scanf("%lld",&c);
        for(ll i = 0; i<c; i++)
        {
            ll u,v,w;
            scanf("%lld %lld %lld",&u,&v,&w);
            graph[u][v] = w;
        }

        ll nGraph[SZ][SZ] = {0};
        scanf("%lld %lld",&B,&D);
        for(ll i = 0; i<B; i++)
        {
            scanf("%lld",&source);
            nGraph[0][source] = INT_MAX;
        }

        for(ll i = 0; i<D; i++)
        {
            scanf("%lld",&sink);
            graph[sink][noOfVertices+1] = INT_MAX;
        }

        nGraph[noOfVertices+1][noOfVertices+2] = INT_MAX;
        auxilary = noOfVertices+3;
        for(ll i = 1; i<=noOfVertices; i++)
        {
            nGraph[i][auxilary] = nodeCapacity[i];
            for(ll j=1; j<=noOfVertices+2; j++)
            {
                if(graph[i][j]>0)
                {
                    nGraph[auxilary][j] = graph[i][j];
                }
            }
            auxilary++;
        }

        for(int i=0;i<=10;i++)
        {
            for(int j=0;j<=10;j++)
                cout<<nGraph[i][j]<<" ";
            cout<<"\n";
        }

        printf("Case %lld: %lld\n",caseNo++,fordFulkerson(nGraph,0,noOfVertices+1));
    }
    return 0;
}

