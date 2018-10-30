#include<bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 100050
#define sf(x) scanf("%lld",&x)
#define inf 1e11

ll testCase,caseNo = 1,n,d,arr[SIZE],treemn[3*SIZE],treemx[3*SIZE];

void init(ll node,ll b,ll e)
{
    if(b==e)
    {
        treemn[node] = treemx[node] = arr[b];
        return;
    }

    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;

    init(Left,b,mid);
    init(Right,mid+1,e);

    treemn[node] = min(treemn[Left],treemn[Right]);
    treemx[node] = max(treemx[Left],treemx[Right]);
}

ll querymn(ll node,ll b,ll e,ll i,ll j)
{
    if(e<i||b>j) return inf;
    if(b>=i&&e<=j) return treemn[node];

    ll mid = (b+e)/2;

    return min(querymn(node*2,b,mid,i,j),
               querymn(node*2+1,mid+1,e,i,j));

}

ll querymx(ll node,ll b,ll e,ll i,ll j)
{
    if(e<i||b>j) return 0;
    if(b>=i&&e<=j) return treemx[node];

    ll mid = (b+e)/2;

    return max(querymx(node*2,b,mid,i,j),
               querymx(node*2+1,mid+1,e,i,j));

}

int main()
{
    sf(testCase);
    while(testCase--)
    {
        sf(n);
        sf(d);
        for(ll i=1;i<=n;i++)
            sf(arr[i]);
        init(1,1,n);

        ll ans = 0;
        for(ll i=1;i+d-1<=n;i++)
        {
            ll ret1 = querymn(1,1,n,i,i+d-1);
            ll ret2 = querymx(1,1,n,i,i+d-1);

            ans = max(ans,ret2-ret1);
        }

        printf("Case %lld: %lld\n",caseNo++,ans);
    }
    return 0;
}
