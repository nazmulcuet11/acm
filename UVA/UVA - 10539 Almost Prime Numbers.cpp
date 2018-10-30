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

#define SIZE_N 1000000+5

bool ok[SIZE_N];
vector<ll> prime;
vector<ll> almostPrime;

void seive()
{
    mem(ok,true);
    for(ll i=2; i<sqrt(SIZE_N)+1; i++)
        if(ok[i])
            for(ll j=i+i; j<SIZE_N+1; j+=i)
                ok[j] = false;

    for(ll i=2;i<SIZE_N;i++)
        if(ok[i])
            for(ll j=i*i;j<=1000000000000;j*=i)
                almostPrime.pb(j);
}

int main()
{
    seive();
    sort(almostPrime.begin(),almostPrime.end());
    ll testCase;
    //freopen("input.txt","r",stdin);
    cin>>testCase;
    while(testCase--)
    {
        ll a,b,cnt=0;
        cin>>a>>b;
        /*for(ll i=0;i<almostPrime.size();i++)
            if(almostPrime[i]>=a&&almostPrime[i]<=b)
                cnt++;

        cout<<cnt<<"\n";*/

        ll li=lower_bound(almostPrime.begin(),almostPrime.end(),a)-almostPrime.begin();
        ll ui=upper_bound(almostPrime.begin(),almostPrime.end(),b)-almostPrime.begin();
        cout<<ui-li<<"\n";

    }
    return 0;
}



