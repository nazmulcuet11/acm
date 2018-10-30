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

#define MOD       1000003
#define SIZE_N      1000005

ll fact[SIZE_N];

ll power(ll b,ll p)
{
    if(p==0)
        return 1;
    if(p%2==0)
    {
        ll ret = power(b,p/2);
        return (ret%MOD*ret%MOD)%MOD;
    }
    else
        return (b*power(b,p-1)%MOD)%MOD;
}

ll ncr(ll n,ll r)
{
    ll ret = fact[n];
    ret = (ret*power(fact[r],MOD-2)%MOD)%MOD;
    ret = (ret*power(fact[n-r],MOD-2)%MOD)%MOD;

    return ret;
}

int main()
{
    fact[0]=fact[1]=1;
    for(ll i=2;i<SIZE_N;i++)
        fact[i]=(fact[i-1]*i%MOD)%MOD;

    ll testCase,caseNo = 1,n,r;
    cin>>testCase;
    //ncr(5,0);
    while(testCase--)
    {
        cin>>n>>r;
        cout<<"Case "<<caseNo++<<": "<<ncr(n,r)<<"\n";
    }
    return 0;
}

