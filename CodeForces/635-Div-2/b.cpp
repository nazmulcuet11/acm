#include <iostream>

using namespace std;
typedef long long ll;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    int test_case;
    cin >> test_case;
    while (test_case--)
    {
        ll h, n, m;
        cin >> h >> n >> m;
        while(h > 20 && n > 0)
        {
            h = (h / 2) + 10;
            n--;
        }

        h -= m * 10;
        
        if(h <=0 ) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    
    return 0;
}
