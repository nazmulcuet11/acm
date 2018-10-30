#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 1600000

struct seg{ll a,b;};
ll testCase,caseNo = 1,n,q;
vector<seg>seg_vec;
vector<ll>query_vec;
set<ll> st;
map<ll,ll> mp;
ll tree[SIZE*3];

void init(ll node,ll b,ll e,ll i,ll j)
{
    if(e<i||b>j) return;
    if(b>=i&&e<=j)
    {
        tree[node]++;
        return;
    }

    ll mid = (b+e)/2;
    init(node*2,b,mid,i,j);
    init(node*2+1,mid+1,e,i,j);
}

ll query(ll node,ll b,ll e,ll i,ll sum)
{
    if(b==e&&e==i) return tree[node]+sum;

    ll mid = (b+e)/2;
    if(i<=mid)
        return query(node*2,b,mid,i,sum+tree[node]);

    return query(node*2+1,mid+1,e,i,sum+tree[node]);
}

int main()
{
    scanf("%lld",&testCase);
    while(testCase--)
    {
        memset(tree,0,sizeof tree);
        scanf("%lld %lld",&n,&q);
        for(ll i=0;i<n;i++)
        {
            seg s;
            scanf("%lld %lld",&s.a,&s.b);
            seg_vec.push_back(s);
            st.insert(s.a);
            st.insert(s.b);
        }
        for(ll i=0;i<q;i++)
        {
            ll x;
            scanf("%lld",&x);
            query_vec.push_back(x);
            st.insert(x);
        }

        set<ll>::iterator it;
        ll k = 0;
        for(it = st.begin();it!=st.end();it++)
            if(!mp[*it])
                mp[*it] = ++k;

        for(ll i=0;i<seg_vec.size();i++)
            init(1,1,k,mp[seg_vec[i].a],mp[seg_vec[i].b]);

        printf("Case %lld:\n",caseNo++);
        for(ll i=0;i<query_vec.size();i++)
            printf("%lld\n",query(1,1,k,mp[query_vec[i]],0));

        seg_vec.clear();
        query_vec.clear();
        mp.clear();
        st.clear();
    }
    return 0;
}
