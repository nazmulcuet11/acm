#include <iostream>
#include <algorithm>

using namespace std;

#define SZ (int)(2e5+5)

struct Data
{
    int a, b, diff;
};

bool comp(Data a, Data b) {
    return a.diff < b.diff;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int n, k;
    Data data[SZ];
    cin >> n >> k;
    for(int i = 0; i < n; i++)
    {
        cin >> data[i].a;
    }
    for(int i = 0; i < n; i++)
    {
        cin >> data[i].b;
        data[i].diff = data[i].a - data[i].b; 
    }

    sort(data, data + n, comp);
    long ans = 0;
    for(int i = 0; i < n; i++)
    {
        if(data[i].diff < 0 || i < k)
            ans += data[i].a;
        else
            ans += data[i].b;
    }
    
    cout << ans << endl;

    return 0;
}
