#include<bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 100050
#define sf(x) scanf("%lld",&x)
#define inf 1e11

ll testCase,caseNo = 1,n,d,arr[SIZE],treemn[3*SIZE],treemx[3*SIZE];

int main()
{
    sf(testCase);
    while(testCase--)
    {
        sf(n);
        sf(d);
        for(ll i=1;i<=n;i++)
            sf(arr[i]);
        deque<pair<ll,ll> >windowmn;
        deque<pair<ll,ll> >windowmx;

        ll ans = 0;

        for(ll i=1;i<=n;i++)
        {
            while(!windowmn.empty()&&windowmn.back().first>=arr[i])
                windowmn.pop_back();
            windowmn.push_back(make_pair(arr[i],i));
            while(!windowmn.empty()&&windowmn.front().second<i-d+1)
                windowmn.pop_front();

            while(!windowmx.empty()&&windowmx.back().first<arr[i])
                windowmx.pop_back();
            windowmx.push_back(make_pair(arr[i],i));
            while(!windowmx.empty()&&windowmx.front().second<i-d+1)
                windowmx.pop_front();

            ans = max(ans,windowmx.front().first-windowmn.front().first);
        }

        printf("Case %lld: %lld\n",caseNo++,ans);
    }
    return 0;
}

