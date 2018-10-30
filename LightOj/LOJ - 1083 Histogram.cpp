#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 30050

ll testCase,caseNo = 1,n,arr[SIZE],tree[SIZE*3];

void init(ll node,ll b,ll e)
{
    if(b==e)
    {
        tree[node] = b;
        return;
    }

    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;
    init(Left,b,mid);
    init(Right,mid+1,e);

    if(arr[tree[Left]]<=arr[tree[Right]])
        tree[node] = tree[Left];
    else
        tree[node] = tree[Right];
}

ll query(ll node,ll b,ll e,ll i,ll j)
{
    if(e<i||b>j) return -1;
    if(b>=i&&e<=j) return tree[node];

    ll mid = (b+e)/2;

    ll L = query(node*2,b,mid,i,j);
    ll R = query(node*2+1,mid+1,e,i,j);

    if(L==-1) return R;
    if(R==-1) return L;

    if(arr[L]<=arr[R]) return L;

    return R;
}

ll area(ll b,ll e)
{
    if(b>e) return 0;

    ll mn = query(1,1,n,b,e);
    ll area1 = arr[mn]*(e-b+1);
    ll area2 = area(b,mn-1);
    ll area3 = area(mn+1,e);

    return max(area1,max(area2,area3));
}

int main()
{
    scanf("%lld",&testCase);
    while(testCase--)
    {
        scanf("%lld",&n);
        for(ll i=1;i<=n;i++)
            scanf("%lld",&arr[i]);
        init(1,1,n);
        printf("Case %lld: %lld\n",caseNo++,area(1,n));
    }
    return 0;
}
