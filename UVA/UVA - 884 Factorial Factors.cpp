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

bool prime[1000];
vector<ll> v;
ll ans[1000000+10];

void seive()
{
    mem(prime,true);
    for(ll i=2; i<sqrt(1000)+1; i++)
        if(prime[i])
            for(ll j=i+i; j<=1000; j+=i)
                prime[j] = false;

    for(ll i=2; i<1000; i++)
            if(prime[i])
                v.pb(i);
}


ll factor(ll n)
{
    ll sum = 0;

    for(ll i=0;i<v.size()&&v[i]<sqrt(n)+1;i++)
    {
        if(n%v[i]==0)
            while(n%v[i]==0)
               n/=v[i],sum++;
    }
    if(n>1)
        sum++;
    return sum;
}

int main()
{
    seive();
    ll n;
    for(ll i=2;i<=1000000;i++)
        ans[i]=ans[i-1]+factor(i);
    while(cin>>n)
    {
        cout<<ans[n]<<"\n";
    }
    return 0;
}

