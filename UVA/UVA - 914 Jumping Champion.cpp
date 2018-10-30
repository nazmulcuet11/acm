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

bool visited[1000000+5];
ll diff[1000000+5];

void seive()
{
    mem(visited,true);
    visited[0] = visited[1] = false;
    for(ll i=2; i<sqrt(1000000+5)+1; i++)
        if(visited[i])
            for(ll j=i+i; j<1000000+5; j+=i)
                visited[j] = false;
}

int main()
{
    seive();
    ll testCase,l,u;
    cin>>testCase;
    while(testCase--)
    {
        vector<ll> prime,v;
        cin>>l>>u;
        for(ll i=l;i<=u;i++)
            if(visited[i])
                prime.pb(i);

        mem(diff,0);
        ll mx = 0,ans;
        for(ll i=1;i<prime.size();i++)
            diff[prime[i]-prime[i-1]]++,mx=max(mx,diff[prime[i]-prime[i-1]]);

        for(ll i=0;i<=u;i++)
            if(diff[i]==mx&&mx)
                v.pb(i);

        if(v.size()>1||mx==0)
            cout<<"No jumping champion\n";
        else
            cout<<"The jumping champion is "<<v[0]<<"\n";

    }
    return 0;
}
