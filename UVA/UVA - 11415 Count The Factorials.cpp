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

#define SIZE_N 10000005

bool ok[SIZE_N];
ll arr[SIZE_N],fact[SIZE_N];

void seive()
{
    mem(ok,true);
    mem(arr,0);
    fact[0]=fact[1]=0;
    for(ll i=2; i<SIZE_N; i++)
    {
        if(ok[i])
        {
            arr[i]=1;
            for(ll j=i+i; j<SIZE_N; j+=i)
            {
                ok[j] = false;
                ll temp = j;
                while(temp%i==0)
                    temp/=i,arr[j]++;
            }
        }
        fact[i]=fact[i-1]+arr[i];
    }
}

int main()
{
    seive();
    ll testCase,n;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        ll pos = (ll)(upper_bound( fact, fact+SIZE_N, n )-fact);
        cout<<pos<<"\n";
    }
    return 0;
}
