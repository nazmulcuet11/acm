#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Edge
{
    int u, v, w;

    Edge(int u, int v, int w)
    {
        this->u = u;
        this->v = v;
        this->w = w;
    }

    bool operator<(const Edge &e) const
    {
        return e.w < w;
    }
};

#define MAX_NODE 100

priority_queue<Edge> pq;
vector<Edge> graph[MAX_NODE];
int cost[MAX_NODE];

void reset()
{
    // reset cost
    for (int i = 0; i < MAX_NODE; i++)
    {
        cost[i] = -1;
    }
    // clear queue
    while (!pq.empty())
    {
        pq.pop();
    }
}

void dijkstra(int src)
{
    reset();

    cost[0] = 0;
    pq.push(Edge(src, src, 0));
    while (!pq.empty())
    {
        Edge e = pq.top();
        pq.pop();

        if (cost[e.v] == -1)
        {
            cost[e.v] = cost[e.u] + e.w;
        }

        for (int i = 0; i < graph[e.v].size(); i++)
        {
            Edge newEdge = graph[e.v][i];
            if (cost[newEdge.v] == -1)
            {
                pq.push(newEdge);
            }
        }
    }
}

vector<Edge> edge_list;
#define INF 9999

bool bellmanford(int N, int src)
{
    reset();

    // set cost to infinity
    for (int i = 0; i < N; i++)
    {
        cost[i] = INF;
    }

    cost[src] = 0;
    for (int i = 0; i < N - 1; i++)
    {
        for (int j = 0; j < edge_list.size(); j++)
        {
            Edge e = edge_list[j];
            if (cost[e.u] != INF && cost[e.v] > cost[e.u] + e.w)
            {
                cost[e.v] = cost[e.u] + e.w;
            }
        }
    }

    for (int j = 0; j < edge_list.size(); j++)
    {
        Edge e = edge_list[j];
        if (cost[e.v] < cost[e.u] + e.w)
        {
            return true;
        }
    }
    return false;
}

int main(int argc, char const *argv[])
{

    freopen("input.txt", "r", stdin);

    int N, E;
    cin >> N >> E;

    for (int i = 0; i < E; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        // graph[u].push_back(Edge(u, v, w));
        // graph[v].push_back(Edge(v, u, w));
        edge_list.push_back(Edge(u, v, w));
    }

    // int src;
    // cin >> src;

    // dijkstra(src);

    // for (int i = 0; i < N; i++)
    // {
    //     cout << cost[i] << endl;
    // }

    cout << bellmanford(N, 0) << endl;
    for (int i = 0; i < N; i++)
    {
        cout << cost[i] << endl;
    }

    return 0;
}
