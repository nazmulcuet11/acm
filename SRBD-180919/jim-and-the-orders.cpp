#include <iostream> 
#include <algorithm>

using namespace std;


#define SZ 1001

struct Data
{
    int id, time;
};

bool comp(Data a, Data b) {
    if( a.time == b.time) return a.id < b.id;
    return a.time < b.time;
}

Data d[SZ];


int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        int x, y;
        cin >> x >> y;
        d[i].id = i + 1;
        d[i].time = x + y;
    }

    sort(d, d + n, comp);

    for(int i = 0; i < n; i++)
        cout << d[i].id << " ";
    
    return 0;
}
