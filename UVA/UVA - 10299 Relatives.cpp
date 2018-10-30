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

#define SIZE_N 50000

bool ok[SIZE_N];
vector<ll> prime;

void seive()
{
    mem(ok,true);
    for(ll i=2;i<sqrt(SIZE_N)+1;i++)
        if(ok)
            for(ll j=i+i;j<SIZE_N;j+=i)
                ok[j] = false;

    for(ll i=2;i<SIZE_N;i++)
        if(ok[i])
            prime.pb(i);
}

ll power(ll n,ll p)
{
    if(p==0) return 1;
    if(p%2==0)
    {
        ll ret = power(n,p/2);
        return ret*ret;
    }
    else return n*power(n,p-1);
}

ll NoOfRelativePrimee(ll n)
{
    if(n==1) return 0;
    ll ret = 1;
    for(ll i=0;i<prime.size()&&prime[i]<sqrt(n)+1;i++)
    {
        if(n%prime[i]==0)
        {
            ll freq = 0;
            while(n%prime[i]==0)
                n/=prime[i],freq++;

            ret*=power(prime[i],freq-1)*(prime[i]-1);
        }
    }
    if(n>1)
        ret*=(n-1);

    return ret;
}

int main()
{
    seive();
    ll n;
    //freopen("input.txt","r",stdin);
    while(cin>>n&&n)
        cout<<NoOfRelativePrimee(n)<<"\n";
    return 0;
}
