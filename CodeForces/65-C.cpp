#include <iostream>
#include <cmath>

#define SZ (int)1e5+5

using namespace std;

int arr[SZ];

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    int n;
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> arr[i];
    
    for(int i = 1; 3*i <= n; i++)
    {
        if(n%i != 0) continue;

        for(int j = 0; j<i; j++)
        {
            int lucky = arr[j];
            for(int k = j; k < n && lucky; k+=i)
                lucky = arr[k];
            if(lucky)
            {
                cout << "YES";
                return 0;
            }
        }
    }
    
    cout << "NO" << endl;
    return 0;
}
