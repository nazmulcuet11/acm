/**Bismillahir Rahmanir Rahim**/
/**
 *    @author     : Nazmul Islam
 *    @College    : CUET CSE 11
 *    @Topcoder   : nazmul_islam
 *    @CodeForces : nazmul_islam
 *    @UVA        : nazmul_cuet11
 *    @link       : https://www.facebook.com/nazmul.shohagh
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long          ll;
typedef unsigned long long llu;

#define ft        first
#define sd        second
#define mp        make_pair
#define pb(x)     push_back(x)
#define lcm(x,y)  x*y/__gcd(x,y)
#define all(x)    x.begin(),x.end()
#define allr(x)   x.rbegin(),x.rend()
#define MAX(a)    (*max_element(all(a)))
#define MIN(a)    (*min_element(all(a)))
#define mem(a,b)  memset(a,b,sizeof(a))
#define inf       1e9
#define eps       1e-9
#define mod       1000000007
#define NN        30100
#define SZ 100005

ll dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
ll dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

bool check_bit(ll n,ll i){return (1<<i)&n;}
ll set_bit(ll n,ll i){return (1<<i|n);}
ll reset_bit(ll n,ll i){return (0<<i&n);}

ll tree[SZ*3];
ll arr[SZ];

ll init(ll node,ll i,ll j)
{
    if(i==j)
    {
        tree[node] = arr[i];
        return tree[node];
    }

    ll mid = (i+j)/2;
    ll left = init(node*2,i,mid);
    ll right = init(node*2+1,mid+1,j);
    return tree[node] = left+right;
}

ll giveAll(ll node,ll i,ll j,ll amnt,ll ind)
{
    if(ind<i||ind>j)
    {
        return tree[node];
    }

    if(i==ind&&j==ind)
    {
        tree[node] = amnt;
        return tree[node];
    }

    ll mid = (i+j)/2;
    ll left = giveAll(node*2,i,mid,amnt,ind);
    ll right = giveAll(node*2+1,mid+1,j,amnt,ind);

    return tree[node] = left+right;
}


ll update(ll node,ll i,ll j,ll amnt,ll ind)
{
    if(ind<i||ind>j)
    {
        return tree[node];
    }

    if(i==ind&&j==ind)
    {
        tree[node] += amnt;
        return tree[node];
    }

    ll mid = (i+j)/2;
    ll left = update(node*2,i,mid,amnt,ind);
    ll right = update(node*2+1,mid+1,j,amnt,ind);

    return tree[node] = left+right;
}

ll query(ll node,ll beg,ll en,ll i,ll j)
{
   if(i<=beg&&j>=en)
        return tree[node];
   if(beg>j||en<i)
        return 0;

   ll mid = (beg+en)/2;
   ll left = query(node*2,beg,mid,i,j);
   ll right = query(node*2+1,mid+1,en,i,j);

   return left+right;
}

int main()
{
	//ios_base::sync_with_stdio(0),cin.tie(0);
	ll testCase,caseNo = 1,n,q,x,y,z;
	scanf("%lld",&testCase);
	while(testCase--)
    {
        printf("Case %lld:\n",caseNo++);
        scanf("%lld %lld",&n,&q);
        for(ll i=1;i<=n;i++)
        {
            scanf("%lld",&arr[i]);
        }

        init(1,1,n);

        for(ll i=0;i<q;i++)
        {
            scanf("%lld",&x);
            if(x==1)
            {
                scanf("%lld",&y);
                printf("%lld\n",query(1,1,n,y+1,y+1));
                giveAll(1,1,n,0,y+1);
            }
            else if(x==2)
            {
                scanf("%lld %lld",&y,&z);
                update(1,1,n,z,y+1);
            }
            else if(x==3)
            {
                scanf("%lld %lld",&y,&z);
                printf("%lld\n",query(1,1,n,y+1,z+1));
            }
        }
    }
    return 0;
}
