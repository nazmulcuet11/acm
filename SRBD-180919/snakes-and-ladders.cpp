#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

#define SZ 205
#define INF 99999

int t, l, s, cost[SZ], mp[SZ];

int main(int argc, char const *argv[])
{
    cin >> t;
    while(t--)
    {
        for(int i = 0; i<SZ; i++)
        {
            mp[i] = i;
            cost[i] = - 1;
        }

        cin >> l;
        while(l--)
        {
            int x, y;
            cin >> x >> y;
            mp[x] = y;
        }
        cin >> l;
        while(l--)
        {
            int x, y;
            cin >> x >> y;
            mp[x] = y;
        }


        queue<int> q;
        q.push(1);
        cost[1] = 0;
        while(!q.empty())
        {
            int u = q.front();
            q.pop();

            for(int i = 1; i <=6; i++)
            {
                int v = mp[u + i];
                if(cost[v] == -1 || cost[v] > cost[u] + 1)
                {
                    cost[v] = cost[u] + 1;
                    q.push(v);
                }
            }
        }
            
        cout <<  cost[100] << endl;

    }
    return 0;
}

