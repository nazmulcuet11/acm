#include <iostream>
#include <algorithm>

using namespace std;

#define SZ (int)(1e5+5)

typedef unsigned long long ull;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    ull n, arr[SZ];
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    
    ull g = arr[0];
    for(int i = 1; i < n; i++)
    {
        g = __algo_gcd(g, arr[i]);
    }

    for(int i = 0; i < n; i++)
    {
        ull d = arr[i] / g;
        for(int j = 2; j <=3; j++)
        {
            while(d > 1 && d%j == 0) 
            {
                d /= j;
            }
        }
        if(d != 1)
        {
            cout << "No" << endl;
            return 0;
        }
    }
    
    cout << "Yes" << endl;
    
    return 0;
}
