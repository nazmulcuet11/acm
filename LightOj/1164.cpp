#include <bits/stdc++.h>

using namespace std;

#define SZ 100050
typedef long long ll;

struct Node
{
    ll sum, prop;
    Node(): sum(0), prop(0) {}; 
};

ll arr[SZ];
Node tree[SZ*4];

void init(ll node, ll l, ll r)
{
    if(l == r)
    {
        tree[node].sum = 0;
        tree[node].prop = 0;
        return;
    }

    ll left = node*2;
    ll right = node*2+1;
    ll m = (l+r)/2;
    init(left, l, m);
    init(right, m+1, r);
    tree[node].sum = tree[left].sum + tree[right].sum;
    tree[node].prop = 0;
}

void update(ll node, ll l, ll r, ll i, ll j, ll x)
{
    if(l > j || r < i) return;

    if(i <= l && r <= j)
    {
        tree[node].sum += (r - l + 1)*x;
        tree[node].prop += x;
        return;
    }

    ll left = node*2;
    ll right = node*2+1;
    ll m = (l+r)/2;

    //push the propagate current node has to it's child
    tree[left].sum += (m - l + 1)*tree[node].prop;
    tree[right].sum += (r - m)*tree[node].prop;
    tree[left].prop += tree[node].prop;
    tree[right].prop += tree[node].prop;
    tree[node].prop = 0;

    update(left, l, m, i, j, x);
    update(right, m+1, r, i, j, x);

    tree[node].sum = tree[left].sum + tree[right].sum;
}

ll query(ll node, ll l, ll r, ll i, ll j)
{
    if(l > j || r < i) return 0;

    if(i <= l && r <= j)
    {
        return tree[node].sum;
    }

    ll left = node*2;
    ll right = node*2+1;
    ll m = (l+r)/2;

    //push the propagate current node has to it's child
    tree[left].sum += (m - l + 1)*tree[node].prop;
    tree[right].sum += (r - m)*tree[node].prop;
    tree[left].prop += tree[node].prop;
    tree[right].prop += tree[node].prop;
    tree[node].prop = 0;

    ll ret1 = query(left, l, m, i, j);
    ll ret2 = query(right, m+1, r, i, j);
    
    return ret1 + ret2;
}

int main()
{
    ll test_case, n, q, case_no = 1;
    scanf("%lld",&test_case);
    while(test_case--)
    {
        scanf("%lld %lld",&n,&q);
        init(1, 1, n);
        printf("Case %lld:\n", case_no++);
 
        ll cmd, x, y, z;
        for(ll i=0;i<q;i++)
        {
            scanf("%lld",&cmd);
            if(cmd==0)
            {
                scanf("%lld %lld %lld",&x,&y,&z);
                update(1,1,n,x+1,y+1,z);
            }
            if(cmd==1)
            {
                scanf("%lld %lld",&x,&y);
                printf("%lld\n",query(1, 1, n, x+1, y+1));
            }
        }
    }
    return 0;
}
