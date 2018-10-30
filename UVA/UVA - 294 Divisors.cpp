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
    for(ll i=2; i<sqrt(50000)+1; i++)
        if(visited[i])
            for(ll j=i+i; j<50000; j+=i)
                visited[j] = false;

    for(ll i=2;i<50000;i++)
        if(visited[i])
            prime.push_back(i);
}

ll divisor(ll n)
{
    ll total = 1;
    for(ll i=0;i<prime.size();i++)
    {
        if(n%prime[i]==0)
        {
            ll frequency = 0;
            while(n%prime[i]==0)
                frequency++,n/=prime[i];

            total*=(frequency+1);
        }
    }
    if(n>1)
        total*=2;

    return total;
}

int main()
{
    seive();
    ll testCase,l,u;
    cin>>testCase;
    while(testCase--)
    {
        cin>>l>>u;
        ll ans = l, optimumValue = 0;
        for(ll i=l;i<=u;i++)
        {
            ll currentValue = divisor(i);
            if(currentValue>optimumValue)
                optimumValue = currentValue,ans = i;
        }
        printf("Between %lld and %lld, %lld has a maximum of %lld divisors.\n",l,u,ans,optimumValue);
    }
    return 0;
}
