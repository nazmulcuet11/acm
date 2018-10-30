#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 50000

bool ok[SIZE_N];
vector <ll> prime;

void seive()
{
    memset(ok,true,sizeof ok);
    ok[0]=ok[1]=false;
    for(ll i=2;i<sqrt(SIZE_N)+1;i++)
        if(ok[i])
            for(ll j=i+i;j<SIZE_N;j+=i)
                ok[j]=false;

    for(ll i=2;i<SIZE_N;i++)
        if(ok[i])
            prime.push_back(i);
}

ll power(ll b,ll p)
{
    if(p==0) return 1;
    if(p%2==0)
    {
        ll temp = power(b,p/2);
        return temp*temp;
    }
    else return b*power(b,p-1);
}

ll solve(ll n)
{
    ll relativePrime = 1,divisor = 1,freq,temp=n;
    for(ll i=0;prime[i]<sqrt(n)+1;i++)
    {
        if(n%prime[i]==0)
        {
            freq = 0;
            while(n%prime[i]==0)
                n/=prime[i],freq++;

            relativePrime*=(prime[i]-1)*power(prime[i],freq-1);
            divisor*=(freq+1);
        }
    }
    if(n>1)
    {
        relativePrime*=(n-1);
        divisor*=2;
    }
    return temp-(relativePrime)-(divisor-1);
}

int main()
{
    //ios_base::sync_with_stdio(0); cin.tie(0);
    seive();
    ll testCase,caseno = 1,n,result,ans;
    while(cin>>n)
    {
        cout<<solve(n)<<"\n";
    }
    return 0;
}


