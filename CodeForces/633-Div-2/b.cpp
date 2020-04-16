// #include <bits/stdc++.h>
#include <iostream> 
#include <algorithm>
#include <vector>


using namespace std;

#define MAX_N 100005

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int test_case, n, arr[MAX_N];
    scanf("%d", &test_case);
    while(test_case--) {
        scanf("%d", &n);
        for(int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }

        sort(arr, arr + n);

        vector<int> ans;
        int l, r;
        if(n % 2 == 0) {
            r = n / 2;
            l = r - 1;
        } else {
            int mid_index = n / 2;
            ans.push_back(arr[mid_index]);
            l = mid_index - 1;
            r = mid_index + 1; 
        }

        while(l >= 0 && r < n)
        {
            ans.push_back(arr[l]);
            ans.push_back(arr[r]);
            l--;
            r++;
        }
        
        for(int i = 0; i < n; i++) {
            printf("%d ", ans[i]);
        }
        printf("\n");
    }
    return 0;
}


// #include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
// #define MAX_N 200005
#define MAX_N 10

struct Node {
    int id, profit;
    Node(int id = 0, int profit = 0) {
        this->id = id;
        this->profit = profit;
    }

    bool operator < (const Node &p) const { 
        return profit < p.profit;
    }
};

vector<int> grpah[MAX_N];
int depth[MAX_N];
int out_deg[MAX_N]; 
int parent[MAX_N];
bool industry[MAX_N];
int industry_cnt[MAX_N];
int visited[MAX_N];
int num_of_child[MAX_N];

void reset(int n) {
    for(int i = 0; i <= n; i++) {
        grpah[i].clear();
        out_deg[i] = 0;
        depth[i] = -1;
        parent[i] = -1;
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
            out_deg[u]++;
            depth[v] = depth[u] + 1;
            parent[v] = u;
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
    freopen("input.txt", "r", stdin);
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

    priority_queue<Node> q;
    for(int i = 1; i<=n; i++) {
        if(out_deg[i] == 0) {
            Node n = Node(i, depth[i]);
            q.push(n);
        }
    }

    while (k-- && !q.empty())
    {
        Node n = q.top(); q.pop();
        int u = n.id;
        industry[u] = true;
        industry_cnt[u] = 1;
        int p = parent[u];
        if (p != -1) {
            out_deg[p]--;
            if(out_deg[p] == 0) {
                q.push(Node(p, depth[p]));
            }
        }
    }

    visited[1] = true;
    dfs2(1);

    int sum = 0;
    for(int i = 1; i <= n; i++) {
        if(!industry[i]) {
            sum += industry_cnt[i];
        }
    }

    cout << sum << endl;

    return 0;
}
