#include <iostream>
// #include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    int test_case;
    scanf("%d", &test_case);
    while(test_case--)
    {
        ll n;
        scanf("%lld", &n);
        if(n % 4 != 0) {
            printf("NO\n");
        } else { 
            printf("YES\n");
            for(ll i = 1; i <= n+1 ; i++) {
                if(i % 2 == 0) {
                    printf("%lld ", i);
                }
            }

            for(ll i = 1; i <= n+1 ; i++) {
                if(i == (n / 2) + 1) continue;
                if(i % 2 != 0) {
                    printf("%lld ", i);
                }
            }
            printf("\n");
        }
    }
    return 0;
}
