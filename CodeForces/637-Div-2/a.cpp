#include <iostream>

using namespace std;
typedef long long ll;

bool is_in_range(ll n, ll a, ll b) {
    return a <= n and n <= b; 
}

bool is_opverlaping(ll a, ll b, ll c, ll d) {
    if(is_in_range(a, c, d)) return true;
    if(is_in_range(b, c, d)) return true;
    if(is_in_range(c, a, b)) return true;
    if(is_in_range(d, a, b)) return true;
    return false;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    ll test_case;
    cin >> test_case;
    while(test_case--)
    {
        ll n, a, b, c, d;
        cin >> n >> a >> b >> c >> d;

        ll mn = (a - b) * n;
        ll mx = (a + b) * n;
        
        if(is_opverlaping(mn, mx, c-d, c+d)) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }
    
    return 0;
}
