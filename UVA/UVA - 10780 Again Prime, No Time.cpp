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

#define SIZE_N 10000+5

bool ok[SIZE_N];
vector<ll> prime;

void seive()
{
    mem(ok,true);
    for(ll i=2; i<sqrt(SIZE_N)+1; i++)
        if(ok[i])
            for(ll j=i+i; j<SIZE_N+1; j+=i)
                ok[j] = false;

    for(ll i=2;i<SIZE_N;i++)
        if(ok[i])
            prime.pb(i);
}

ll trailingZeros(ll b, ll n)
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

int main()
{
    //freopen("input.txt","r",stdin);
    seive();
    ll n,m,testCase,caseNo = 1;
    cin>>testCase;
    while(testCase--)
    {
        cin>>m>>n;
        ll ans = trailingZeros(m,n);
        cout<<"Case "<<caseNo++<<":\n";
        if(ans) cout<<ans<<"\n";
        else cout<<"Impossible to divide\n";
    }
    return 0;
}
