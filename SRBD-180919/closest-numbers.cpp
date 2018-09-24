#include <iostream>
#include <algorithm>

using namespace std;

#define SZ 200005

typedef long long ll;

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

    ll min_diff = 2*10000005;
    for(int i = 1; i < n; i++)
    {
        min_diff = min(min_diff, abs(arr[i] - arr[i - 1]));
    }

    for(int i = 0; i < n; i++)
    {
        if(abs(arr[i] - arr[i - 1]) == min_diff)
        {
            cout << arr[i - 1] << " " << arr[i] << " ";
        }
    } 

    return 0;
}
