#include <iostream>

using namespace std;

#define SZ 1001

int prime_cnt, primes[SZ];

void seive() {
    prime_cnt = 0;
    bool is_prime[SZ];
    for(int i = 0; i < SZ; i++)
        is_prime[i] = true;
    is_prime[0] = is_prime[1] = false;

    for(int i = 2; i < SZ; i++)
    {
        if(is_prime[i])
        {
            primes[prime_cnt++] = i;
            for(int j = 2*i; j < SZ; j += i)
                is_prime[j] = false;
        }
    }
}

int main(int argc, char const *argv[])
{
    seive();
    
    int n;
    cin >> n;
    
    int ans[SZ], ans_cnt = 0;
    for(int i = 0; i < prime_cnt && primes[i] <= n; i++)
    {
        int t = primes[i];
        while(t <= n)
        {
            ans[ans_cnt++] = t;
            t *= primes[i];
        }
    }

    cout << ans_cnt << endl;
    for(int i = 0; i < ans_cnt; i++)
        cout << ans[i] << " ";

    return 0;
}
