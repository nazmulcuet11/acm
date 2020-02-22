#include <iostream>

using namespace std;
typedef long long ll;

#define MAX_N 1000005
#define MOD 1000000000

ll dp[MAX_N];

int main(int argc, char const **argv)
{
    ll n;
    cin >> n;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
        dp[i] = dp[i-1];
        if(i%2 == 0) {
            dp[i] = (dp[i] + dp[i/2]) % MOD;
        }
    }
    cout << dp[n] << endl;
    return 0;
}
