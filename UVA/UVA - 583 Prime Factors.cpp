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

bool visited[50000];
vector<ll> prime;

void seive()
{
    mem(visited,true);
    for(ll i=2;i<sqrt(50000)+1;i++)
        if(visited[i])
            for(ll j=i+i;j<=50000;j+=i)
                visited[j] = false;
    for(ll i=2;i<50000;i++)
        if(visited[i])
            prime.pb(i);
}

void factor(ll n)
{
    vector<ll> v;
    if(n<0)
        v.pb(-1),n*=-1;
    for(ll i=0;i<prime.size()&&prime[i]<=sqrt(n);i++)
    {
        if(n%prime[i]==0)
        {
            while(n%prime[i]==0)
            {
                n/=prime[i];
                v.pb(prime[i]);
            }
        }
    }
    if(n>1)
        v.pb(n);

    for(ll i=0;i<v.size();i++)
        if(i==0)
            cout<<" "<<v[i];
        else
            cout<<" x "<<v[i];
    cout<<"\n";
}

int main()
{
    seive();
    ll n;
    while(cin>>n&&n)
    {
        cout<<n<<" =";
        factor(n);
    }
    return 0;
}
