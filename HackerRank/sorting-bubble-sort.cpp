#include <bits/stdc++.h>

using namespace std;


int main(int argc, char const *argv[])
{
    int n, a[700], cnt = 0;

    cin >> n;
    
    for(int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n - 1; j++) 
        {
            // Swap adjacent elements if they are in decreasing order
            if (a[j] > a[j + 1]) 
            {
                swap(a[j], a[j + 1]);
                cnt++;
            }
        }
    }

    cout << "Array is sorted in " << cnt << " swaps." << endl;
    cout << "First Element: " << a[0] << endl;
    cout << "Last Element: " << a[n-1] << endl;
    return 0;
}
