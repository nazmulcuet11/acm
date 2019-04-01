// UVA - 539 The Settlers of Catan

#include <iostream>

#define MAX_NODE 26
#define MASK_SIZE (33554432 + 5) // 2^25 

using namespace std;

typedef long long ll;

int number_of_node, number_of_edge;
int edges[MAX_NODE][MAX_NODE];
bool should_go[MAX_NODE][MAX_NODE];
bool processed[MAX_NODE];

void mark_shouldgo(int i, int j, bool val) 
{
    should_go[i][j] = val;
    should_go[j][i] = val;
}

ll solve(int u, int mask)
{
    ll mx = 0;
    for(int v = 0; v < number_of_node; v++)
    {
        if(!should_go[u][v] || edges[u][v] == -1)
            continue;

        mark_shouldgo(u, v, false);
        mx = max(mx, solve(v, mask << edges[u][v]) + 1);
        mark_shouldgo(u, v, true);
    }
    return mx;
}

void flood(int u) 
{
    processed[u] = true;
    for(int v = 0; v < number_of_node; v++)
    {
        if(edges[u][v] == -1)
            continue;
        if(processed[v])
            continue;
        flood(v);
    }
}

void init() 
{
    for(int i = 0; i < MAX_NODE; i++) 
    {
        for(int j = 0; j < MAX_NODE; j++)
        {
            edges[i][j] = -1;
            should_go[i][j] = true;
        }
        should_go[i][i] = false;
        processed[i] = false;
    }
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    while(cin >> number_of_node >> number_of_edge && number_of_node && number_of_edge) {
        init();

        for(int i = 0; i < number_of_edge; i++)
        {
            int u, v;
            cin >> u >> v;
            edges[u][v] = i;
            edges[v][u] = i;
        }
        
        ll mx = 0;
        for(int i = 0; i < number_of_node; i++)
        {
            mx = max(mx, solve(i, 0));
        }
        cout << mx << endl;
    }
    
    return 0;
}
