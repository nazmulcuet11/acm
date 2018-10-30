#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 100050

int main()
{
    int testCase;
    scanf("%d", &testCase);
    ll virat[SIZE], rohit[SIZE];
    ll n, m, s, p, q;

    while(testCase--)
    {
        scanf("%lld %lld %lld %lld %lld", &n, &m, &s, &p, &q);
        virat[0] = rohit[0] = 1;

        ll cnt = 0;

        for(int i = 1; i<=s ; i++)
        {
            virat[i] = virat[i-1] + p;
            rohit[i] = rohit[i-1] + q;

            if(virat[i]>=m)
                virat[i] = (virat[i] - m)%(n-m+1) + m;

            if(rohit[i]>=m)
                rohit[i] = (rohit[i] - m)%(n-m+1) + m;


            if(virat[i] == rohit[i])
                cnt++;
        }

        printf("%lld\n",cnt);
    }
    return 0;
}
