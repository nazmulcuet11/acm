#include <bits/stdc++.h>

using namespace std;

#define SIZE 1000+5

typedef long long ll;

int dx[4] = { 0, 0, 1,-1};
int dy[4] = { 1,-1, 0, 0};

ll r, c, graph[SIZE][SIZE], cost[SIZE][SIZE];

bool can_go(ll ux, ll uy, ll dirx, ll diry)
{
    ll val = graph[ux][uy];

    if(dirx == 0 && diry == 1)
    {
        if(val == 1 || val == 3 || val == 4 || val == 5)
            return true;
    }
    if(dirx == 1 && diry == 0)
    {
        if(val == 1 || val == 2 || val == 5 || val == 6)
            return true;
    }
    if(dirx == 0 && diry == -1)
    {
        if(val == 1 || val == 3 || val == 6 || val == 7)
            return true;
    }
    if(dirx == -1 && diry == 0)
    {
        if(val == 1 || val == 2 || val == 4 || val == 7)
            return true;
    }
    return false;
}

void _clear()
{
    for(int i = 0; i<SIZE; i++)
        for(int j = 0; j<SIZE; j++)
            cost[i][j] = -1;
}

ll bfs(ll ux, ll uy, ll l)
{
    if(!graph[ux][uy])
        return 0;

    _clear();
    queue<pair<ll, ll> > q;
    q.push(make_pair(ux, uy));
    cost[ux][uy] = 0;
    ll cnt = 1;

    while(!q.empty())
    {
        ux = q.front().first;
        uy = q.front().second;
        q.pop();

        for(int i = 0; i<4; i++)
        {
            ll vx = ux + dx[i];
            ll vy = uy + dy[i];

            if(vx >= r || vy >=c || vx <0 || vy <0)
                continue;
            if(!graph[vx][vy])
                continue;
            if(cost[vx][vy] != -1)
                continue;
            if(!can_go(ux, uy, dx[i], dy[i]))
                continue;
            if(!can_go(vx, vy, -dx[i], -dy[i]))
                continue;
            if(cost[ux][uy] + 1 >= l)
                continue;
            
            cost[vx][vy] = cost[ux][uy] + 1;
            cnt++;
            q.push(make_pair(vx, vy));
        }
    }

    return cnt;
}

int main()
{
    freopen("input.txt", "r", stdin);

    ll test_case, strtx, strty, l;

    cin >> test_case;
    while(test_case--)
    {
        cin >> r >> c >> strtx >> strty >> l;;
        for(int i = 0; i< r; i++)
            for(int j = 0; j < c; j++)
                cin>> graph[i][j];

        cout << bfs(strtx, strty, l) << endl;
    }
    return 0;
}