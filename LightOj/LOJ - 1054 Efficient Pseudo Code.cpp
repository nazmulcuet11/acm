#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 50000
#define MOD  1000000007

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
    if(p==0)
        return 1;
    if(p%2==0)
    {
        ll ret = power(b,p/2);
        return (ret%MOD*ret%MOD)%MOD;
    }
    else
        return (b*power(b,p-1)%MOD)%MOD;
}

ll sumOfDevisors(ll n,ll m)
{
    if(n==MOD) return 1;
    ll ret = 1;
    for(ll i=0;prime[i]<sqrt(n)+1;i++)
    {
        if(n%prime[i]==0)
        {
            ll freq = 0;
            while(n%prime[i]==0)
                freq++,n/=prime[i];

            ret=(ret*(power(prime[i],(freq*m+1))-1)%MOD)%MOD;
            ret=(ret*power((prime[i]-1),MOD-2)%MOD)%MOD;
        }
    }
    if(n>1)
    {
        ret=(ret*(power(n,m+1)-1)%MOD)%MOD;
        ret=(ret*power((n-1),MOD-2)%MOD)%MOD;
    }

    return ret;
}

int main()
{
    seive();
 //   freopen("input.txt","r",stdin);
    ll testCase,caseNo = 1,n,m;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>m;
        n=fabs(n);m=fabs(m);
        cout<<"Case "<<caseNo++<<": "<<sumOfDevisors(n,m)<<"\n";
    }
    return 0;
}
