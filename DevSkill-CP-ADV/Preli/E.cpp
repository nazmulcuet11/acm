#include <iostream>
#include <cmath>

using namespace std;
typedef long long ll;

ll gcd(ll a, ll b) {
    if (a == 0) 
        return b; 
    return gcd(b%a, a);
}

ll joke(ll a, ll b) {
    ll n = gcd(a, b);
    ll cnt = 0;
    for(int i = 1; i  <= sqrt(n); i++) {
        if (n % i == 0) {
            if (n /i == i) {
                cnt += 1;
            } else {
                cnt += 2;
            }
        }
    }
    return cnt;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    ll t, a, b;
    scanf("%lld", &t);
    while(t--) {
        scanf("%lld %lld", &a, &b);
        ll ans = joke(a, b);
        printf("%lld\n", ans);
    }
    return 0;
}
