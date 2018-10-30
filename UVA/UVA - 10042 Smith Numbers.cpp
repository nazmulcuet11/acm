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

bool ok[50000];
vector<ll> prime;
vector<ll> factor;
void seive()
{
    mem(ok,true);
    for(ll i=2;i<sqrt(50000)+1;i++)
        if(ok[i])
            for(ll j=i+i;j<50000;j+=i)
                ok[j] = false;

    for(ll i=2;i<50000;i++)
        if(ok[i])
            prime.pb(i);
}

ll sumOfDigit(ll n)
{
    ll sum = 0;
    while(n>0)
        sum+=n%10,n/=10;

    return sum;
}

ll sumOfFactor(ll n)
{
    ll sum = 0;
    for(ll i=0;prime[i]<sqrt(n)+1;i++)
        if(n%prime[i]==0)
            while(n%prime[i]==0)
                sum+=sumOfDigit(prime[i]),n/=prime[i];
    if(n>1)
        sum+=sumOfDigit(n);

    return sum;
}

bool isPrime(ll n)
{
    if(n<50000)
        return ok[n];
    for(ll i=0;i<prime.size()&&prime[i]<sqrt(n)+1;i++)
        if(n%prime[i]==0)
            return false;

    return true;
}

int main()
{
    seive();
    ll testCase,n;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        for(ll i=n+1;;i++)
        {
            if(!isPrime(i)&&sumOfDigit(i) == sumOfFactor(i))
            {
                cout<<i<<"\n";
                break;
            }
        }
    }
    return 0;
}
