#include <iostream>
#include <algorithm>

using namespace std;

#define SZ (int)(3*1e5+5)

typedef unsigned long long ll;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    ll n, arr[SZ];
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    
    sort(arr, arr + n);

    ll ans = 0;
    for(int i = 0; i < n - 1; i++)
    {
        ans += arr[i]*(i + 2);
    }
    ans += arr[n-1]*n;

    cout << ans << endl;

    return 0;
}
