// #include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
#define MAX_N 200005
// #define MAX_N 10

struct Node {
    int id, profit;
    Node(int id = 0, int profit = 0) {
        this->id = id;
        this->profit = profit;
    }

    bool operator < (const Node &p) const { 
        return profit > p.profit;
    }
};

vector<int> grpah[MAX_N];
int depth[MAX_N];
bool industry[MAX_N];
int industry_cnt[MAX_N];
int visited[MAX_N];
int num_of_child[MAX_N];

void reset(int n) {
    for(int i = 0; i <= n; i++) {
        grpah[i].clear();
        depth[i] = -1;
        industry[i] = false;
        industry_cnt[i] = 0;
        visited[i] = false;
        num_of_child[i] = 0;
    }
}

void dfs(int u) {
    for(int i = 0; i < grpah[u].size(); i++) {
        int v = grpah[u][i];
        if(depth[v] == -1) 
        {
            depth[v] = depth[u] + 1;
            dfs(v);
            num_of_child[u] += num_of_child[v] + 1;
        }
    }
}

void dfs2(int u) {
    int cnt = 0;
    for(int i = 0; i < grpah[u].size(); i++) {
        int v = grpah[u][i];
        if(visited[v] == false) 
        {
            visited[v] = true;
            dfs2(v);
            industry_cnt[u] += industry_cnt[v];
        }
    }
}

Node nodes[MAX_N];
int main(int argc, char const *argv[])
{
    int n, k;
    // freopen("input.txt", "r", stdin);
    scanf("%d %d", &n, &k);
    reset(n);

    for(int i = 0; i < n; i++)
    {
        int u, v;
        scanf("%d %d", &u, &v);
        grpah[u].push_back(v);
        grpah[v].push_back(u);
    }
    
    depth[1] = 0;
    dfs(1);
    for(int i = 1; i<=n; i++) {
        nodes[i] = Node(i, depth[i] - num_of_child[i]);
    }
    sort(nodes + 1, nodes + n + 1);

    for (int i = 1; i <= k; i++)
    {
        int u = nodes[i].id;
        industry[u] = true;
        industry_cnt[u] = 1;
    }

    visited[1] = true;
    dfs2(1);

    long long sum = 0;
    for(int i = 1; i <= n; i++) {
        if(!industry[i]) {
            sum += industry_cnt[i];
        }
    }

    cout << sum << endl;

    return 0;
}
