#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 100050

struct info{ll val,prop;};

ll testCase,caseNo=1,n,q,arr[SIZE];
info tree[4*SIZE];

void init(ll node,ll b,ll e)
{
    if(b==e)
    {
        tree[node].val = 0;
        tree[node]. prop = 0;
        return;
    }
    ll mid = (b+e)/2;
    ll Left = node*2;
    ll Right = node*2+1;

    init(Left,b,mid);
    init(Right,mid+1,e);

    tree[node].val = tree[Left].val + tree[Right].val;
    tree[node].prop = 0;
}

void update(ll node,ll b,ll e,ll i,ll j,ll val)
{
    if(e<i||b>j) return;
    if(b>=i&&e<=j)
    {
        tree[node].prop+=val;
        tree[node].val+=(e-b+1)*val;
        return;
    }

    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;

    update(Left,b,mid,i,j,val);
    update(Right,mid+1,e,i,j,val);

    tree[node].val = tree[Left].val+tree[Right].val+(e-b+1)*tree[node].prop;
}

ll query(ll node,ll b,ll e,ll i,ll j,ll prop)
{
    if(e<i||b>j) return 0;
    if(b>=i&&e<=j)
    {
        return (prop)*(e-b+1)+tree[node].val;
    }

    ll Left = node*2;
    ll Right = node*2+1;
    ll mid = (b+e)/2;

    return query(Left,b,mid,i,j,prop+tree[node].prop)+
            query(Right,mid+1,e,i,j,prop+tree[node].prop);

}

int main()
{
    scanf("%lld",&testCase);
    while(testCase--)
    {
        scanf("%lld %lld",&n,&q);
        init(1,1,n);
        printf("Case %lld:\n",caseNo++);

        ll cmd,x,y,z;
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
                printf("%lld\n",query(1,1,n,x+1,y+1,0));
            }
        }
    }
    return 0;
}
