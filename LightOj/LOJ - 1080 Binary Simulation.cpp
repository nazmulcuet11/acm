#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SZ 100005

char str[SZ];
ll testCase,caseNo = 1,n,q,i,j;
char opt;

struct info
{
    ll prop,sum;
    info(ll p=0,ll s=0)
    {
        this->prop=p;
        this->sum=s;
    }
};

info tree[SZ*3];
ll arr[SZ];

void init(ll node,ll b,ll e)
{
    if(b==e)
    {
        tree[node]=info(0,0);
        return;
    }
    ll Left=node*2;
    ll Right=node*2+1;
    ll mid=(b+e)/2;
    init(Left,b,mid);
    init(Right,mid+1,e);
    tree[node].sum = 0;
    tree[node].prop = 0;
}

void update(ll node,ll b,ll e,ll i,ll j)
{
    if (i > e || j < b) return;

    if (b >= i && e <= j) //নোডের রেঞ্জ আপডেটের রেঞ্জের ভিতরে
    {
        //tree[node].sum+=((e-b+1)*x); //নিচে নোড আছে e-b+1 টি, তাই e-b+1 বার x যোগ হবে এই রেঞ্জে
        tree[node].prop^=1; //নিচের নোডগুলোর সাথে x যোগ হবে
        return;
    }

    ll Left=node*2;
    ll Right=(node*2)+1;
    ll mid=(b+e)/2;
    update(Left,b,mid,i,j);
    update(Right,mid+1,e,i,j);
    //tree[node].sum=tree[Left].sum+tree[Right].sum+(e-b+1)*tree[node].prop;
    ///উপরে উঠার সময় পথের নোডগুলো আপডেট হবে
    ///বাম আর ডান পাশের SUM ছাড়াও যোগ হবে নিচে অতিরিক্ত যোগ হওয়া মান
}

ll query(ll node,ll b,ll e,ll i,ll carry)
{
    if(b==i&&i==e)
    {
        return (str[i-1]-'0')^carry;
    }
    ll Left=node*2;
    ll Right=node*2+1;
    ll mid=(b+e)/2;
    if(i<=mid)
        return query(Left,b,mid,i,carry^tree[Left].prop);

    return query(Right,mid+1,e,i,carry^tree[Right].prop);
}

int main()
{
    scanf("%lld",&testCase);
    while(testCase--)
    {
        getchar();
        gets(str);
        n = strlen(str);
        init(1,1,n);
        scanf("%lld",&q);
        printf("Case %lld:\n",caseNo++);
        while(q--)
        {
            getchar();
            scanf("%c",&opt);
            if(opt=='I')
            {
                scanf("%lld %lld",&i,&j);
                update(1,1,n,i,j);
            }
            else
            {
                scanf("%lld",&i);
                printf("%lld\n",query(1,1,n,i,tree[1].prop));
            }
        }
    }
    return 0;
}
