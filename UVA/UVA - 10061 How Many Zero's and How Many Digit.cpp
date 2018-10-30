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

bool ok[800+10];
vector<ll> prime;

void seive()
{
    mem(ok,true);
    for(ll i=2;i<sqrt(800)+1;i++)
        if(ok[i])
            for(ll j=i+i;j<=800;j+=i)
                ok[j]=false;
    for(ll i=2;i<=800;i++)
        if(ok[i])
            prime.pb(i);
}

ll trailingZeros(ll n, ll b)
{
    ll ans = numeric_limits<ll>::max();
    for(ll i=0;i<prime.size()&&prime[i]<=b;i++)
    {
        ll temp = b,freq = 0, cnt = 0;
        while(temp%prime[i]==0)
            freq++,temp/=prime[i];

        if(!freq) continue; //If prime[i] is not a factor of b

        temp = n;
        while(temp>0)
            cnt+=temp/prime[i],temp/=prime[i];

        ans = min(ans,cnt/freq);
    }
    return ans;
}

ll digitOfFactorial(ll n,ll b)
{
    double sum = 0.00;
    for(ll i=1; i<=n; i++)
        sum+=log10(i);

    sum/=log10(b);
    sum = floor(sum+1e-9)+1.00;
    return (ll)(sum);
}

int main()
{
    //freopen("input.txt","r",stdin);
    seive();
    ll n,b;
    while(cin>>n>>b)
    {
        cout<<trailingZeros(n,b)<<" "<<digitOfFactorial(n,b)<<"\n";
    }
    return 0;
}
