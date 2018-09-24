#include <iostream>
#include <algorithm>

using namespace std;

#define SZ 100001

typedef long long ll;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    ll n, m, already_has[SZ], toy_count = 0, new_toys[SZ];
    cin >> n >> m;
    for(int i = 0; i < n; i++)
    {
        cin >> already_has[i];
    }

    sort(already_has, already_has + n);
    ll c = 1, i = 0;
    while(m > 0 && i < n)
    {
        while(c < already_has[i] && (m-c) >= 0 )
        {
            new_toys[toy_count++] = c;
            m -= c;
            c++;
        }
        c = already_has[i] + 1;
        i++;
    }
    while(m-c >= 0)
    {
        new_toys[toy_count++] = c;
        m -= c;
        c++;
    }

    cout << toy_count << endl;
    for(int i = 0; i < toy_count; i++)
        cout << new_toys[i] << " ";
    
    return 0;
}
