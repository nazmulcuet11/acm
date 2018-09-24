#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

#define SZ (int)(1e5+5)

typedef long long ll;

int main(int argc, char const *argv[])
{
    ll n, sorted[SZ], orig[SZ];
    bool visited[SZ];
    map<ll, int> mp;

    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> orig[i];
        sorted[i] = orig[i];
    }

    sort(sorted, sorted + n);

    for(int i = 0; i<n; i++)
    {
        mp[orig[i]] = i;
        visited[i] = false;
    }

    ll ans = 0;
    for(int i = 0; i < n; i++)
    {
        int cycle_length = 0;
        int t = mp[sorted[i]];
        while(!visited[t]) 
        {
            visited[t] = true;
            cycle_length++;
            t = mp[sorted[t]];
        }
        ans += max(0, cycle_length - 1);
    }

    cout << ans << endl;

    return 0;
}
