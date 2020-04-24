#include <iostream>
// #include <bits/stdc++.h>

using namespace std;
typedef long long ll;


#define MAX_N 2000050
ll a[MAX_N];
ll taken[MAX_N];

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    ll test_case;
    scanf("%lld", &test_case);
    while(test_case--)
    {
        ll n;
        scanf("%lld", &n);
        for (int i = 0; i < n; i++)
        {
            ll x;
            scanf("%lld", &x);
            a[i] = x;
        }

        for(int i = 0; i < n + 5; i++) {
            taken[i] = false;
        }
        
        bool possible = true;
        ll max_possible = n;
        for(int i = 0; i < n; i++) {
            taken[a[i]] = true;
            if(a[i] < max_possible) {
                if(i + 1 < n && a[i+1] != a[i]+1) {
                    possible = false;
                    break;
                }
            } else {
                while (taken[max_possible])
                {
                    max_possible--;
                }
            }
        }

        if(possible) {
            printf("Yes\n");
        } else {
            printf("No\n");
        }
    }
    
    return 0;
}
