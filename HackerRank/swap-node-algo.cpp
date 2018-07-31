#include <bits/stdc++.h>

using namespace std;

#define SZ 1030

int n, k, t, l[SZ], r[SZ], d[SZ];

void print_inorder(int i)
{
    if(i == -1) return;
    
    print_inorder(l[i]);
    cout << i << " ";
    print_inorder(r[i]);
}

void swap_nodes()
{
    for (int i = 1; i <= n; i++)
    {
        if (d[i] % k == 0)
        {
            swap(l[i], r[i]);
        }
    }
    print_inorder(1);
    cout << endl;
}

int main(int argc, char const *argv[])
{
    cin >> n;

    d[1] = 1;
    for (int i = 1; i <= n; i++)
    {
        cin >> l[i] >> r[i];
        d[l[i]] = d[r[i]] = d[i] + 1;
    }

    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> k;
        swap_nodes();
    }
    return 0;
}