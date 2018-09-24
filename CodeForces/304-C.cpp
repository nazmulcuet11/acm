#include <iostream>
#include <queue>

using namespace std;

#define INF 3628801

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int n, x, t, cnt = 0;
    queue<int> a, b;
    cin >> n;
    cin >> x;
    for(int i = 0; i < x; i++)
    {
        cin >> t;
        a.push(t);
    }
    cin >> x;
    for(int i = 0; i < x; i++)
    {
        cin >> t;
        b.push(t);
    }

    while(!a.empty() && !b.empty() && cnt < INF)
    {
        if(a.front() > b.front())
        {
            a.push(b.front());
            a.push(a.front());
        }
        else
        {
            b.push(a.front());
            b.push(b.front());
        }

        a.pop();
        b.pop();
        cnt++;
    }

    if(cnt >= INF)
    {
        cout << -1 << endl;
    } 
    else 
    {
        cout << cnt << " ";
        if(a.empty()) cout << 2 << endl;
        else cout << 1 << endl;
    }
    
    return 0;
}
