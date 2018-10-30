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

void seive()
{
    mem(prime,true);
    for(ll i=2;i<sqrt(1000)+1;i++)
        if(prime[i])
            for(ll j=i+i;j<1000;j+=i)
                prime[j] = false;
}

int main()
{
    seive();
    ll N,C;
    while(cin>>N>>C)
    {
        vector<ll>v;
        for(ll i=1;i<=N;i++)
            if(prime[i])
                v.pb(i);

        ll sz = v.size(),start;

        cout<<N<<" "<<C<<":";

        if(sz%2==0)
            C*=2;
        else
            C*=2,C--;
        if(C>sz)
            start = 0;
        else
            start = (sz-C)/2;

        for(ll i=start;i<v.size()&&C;i++,C--)
            cout<<" "<<v[i];
        cout<<"\n\n";
    }
    return 0;
}
