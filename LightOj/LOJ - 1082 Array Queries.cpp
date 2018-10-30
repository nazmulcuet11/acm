#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SZ 900000+50
#define inf 900000+50

ll testCase,caseNo = 1,n,q,arr[SZ],tree[SZ*10];

void init(ll node,ll b,ll e)
{
    if(b==e)
    {
        tree[node] = arr[b];
        return;
    }
    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;

    init(Left,b,mid);
    init(Right,mid+1,e);

    tree[node] = min(tree[Left],tree[Right]);
}

ll query(ll node,ll b,ll e,ll i,ll j)
{
    if(i>e||j<b) return inf;

    if(i<=b&&e<=j) return tree[node];

    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;

    ll ret1 = query(Left,b,mid,i,j);
    ll ret2 = query(Right,mid+1,e,i,j);

    return min(ret1,ret2);
}

int main()
{
    scanf("%lld",&testCase);
    while(testCase--)
    {
        scanf("%lld %lld",&n,&q);
        for(ll i=1;i<=n;i++)
            scanf("%lld",&arr[i]);

        init(1,1,n);

        ll x,y;
        printf("Case %lld:\n",caseNo++);
        for(ll i=0;i<q;i++)
        {
            scanf("%lld %lld",&x,&y);
            printf("%lld\n",query(1,1,n,x,y));
        }
    }
    return 0;
}
