#include <iostream>
#include <cmath>
#include <vector>

using namespace std;
typedef unsigned long long ull;

#define MAX_PRIME 100000000+5
#define MAX_PRIME_ARRAY_SIZE 1562500+5
#define TOTAL_PRIMES 5761455+5

ull is_prime[MAX_PRIME_ARRAY_SIZE];
int prime_count;
unsigned primes[TOTAL_PRIMES];
unsigned dp[TOTAL_PRIMES];

void calculate_primes() {
	for (ull i = 3; i <= sqrt(MAX_PRIME); i += 2) {
        bool i_is_prime = !(is_prime[i / 64] & (1LL <<( i % 64)));
		if(i_is_prime) {
			for(ull j = i * i; j <= MAX_PRIME; j += 2 * i) {
				is_prime[j / 64] |= (1LL << (j % 64));
			}
		}
	}

    prime_count = 0;
	primes[prime_count] = 2;
    dp[prime_count++] = 2;
	for (ull i = 3; i < MAX_PRIME; i += 2) {
        bool i_is_prime = !(is_prime[i / 64] & (1LL <<( i % 64)));
		if(i_is_prime) {
            dp[prime_count] = dp[prime_count-1] * i;
			primes[prime_count++] = i;
		}
	}
}

unsigned ans_upto_sqrt(int n) {
    unsigned ans = 1;
    for(int i = 0; primes[i] * primes[i] <= n; i++) {
        unsigned val = n / primes[i];
        unsigned k = 1;
        while(k * primes[i] <= val) {
            k *= primes[i];
        }
        ans = ans * k;
    }
    return ans;
}

int upper_bound(int n) {
    int l = 0, h = prime_count-1;
    while (l < h) {
        int m = l + (h - l + 1) / 2;
        if(primes[m] <= n) {
            l = m;
        } else {
            h = m-1;
        }
    }
    return l;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    calculate_primes();
    // cout << primes.size();
    int t;
    scanf("%d", &t);
    for(int case_no = 1; case_no <= t; case_no++) {
        int n;
        scanf("%d", &n);
        unsigned ans = ans_upto_sqrt(n);
        int index = upper_bound(n);
        ans *= dp[index];
        printf("Case %d: %u\n", case_no, ans);
    }
    return 0;
}