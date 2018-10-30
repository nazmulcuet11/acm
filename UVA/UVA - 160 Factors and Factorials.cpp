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

bool prime[200];

void seive()
{
    mem(prime,true);
    for(ll i=2; i<sqrt(200)+1; i++)
        if(prime[i])
            for(ll j=i+i; j<200; j+=i)
                prime[j] = false;
}


ll countFactor(ll n,ll p)
{
    ll sum = 0;
    while(n)
    {
        sum+=n/p;
        n/=p;
    }
    return sum;
}

int main()
{
    seive();
    ll n;
    while(cin>>n&&n)
    {
        vector<ll>v;
        for(ll i=2; i<100; i++)
            if(prime[i])
                v.pb(countFactor(n,i));

        printf("%3lld! =", n);

        while(v.back() == 0)
            v.pop_back();

        int flag = 0;

        for (ll i = 0; i <v.size(); i++)
        {
            if (flag == 15)
                printf("\n%6c",' ');
            printf("%3lld", v [i]);
            flag++;
        }
        printf("\n");
    }
    return 0;
}
