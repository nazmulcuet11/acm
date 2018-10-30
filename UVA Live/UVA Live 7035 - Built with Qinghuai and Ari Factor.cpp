#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main()
{
    ll testCase, n, s, caseNo = 1;
    scanf("%lld", &testCase);

    while(testCase--)
    {
        scanf("%lld", &n);

        bool qinghuai = true;
        for(ll i = 0; i<n; i++)
        {
            scanf("%lld", &s);
            if(s%3)
                qinghuai = false;
        }

        if(qinghuai)
            printf("Case #%lld: Yes\n",caseNo++);
        else
            printf("Case #%lld: No\n",caseNo++);
    }
    return 0;
}
