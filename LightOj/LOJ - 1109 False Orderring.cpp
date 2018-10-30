#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 50

bool ok[SIZE_N];
vector <ll> prime;

void seive()
{
    memset(ok,true,sizeof ok);
    ok[0]=ok[1]=false;
    for(ll i=2; i<sqrt(SIZE_N)+1; i++)
        if(ok[i])
            for(ll j=i+i; j<SIZE_N; j+=i)
                ok[j]=false;

    for(ll i=2; i<SIZE_N; i++)
        if(ok[i])
            prime.push_back(i);
}

ll noOfDevisor(ll n)
{
    ll ret = 1;
    for(ll i=0;prime[i]<sqrt(n)+1;i++)
    {
        if(n%prime[i]==0)
        {
            ll freq = 0;
            while(n%prime[i]==0)
                freq++,n/=prime[i];
            ret*=(freq+1);
        }
    }
    if(n>1)
        ret*=2;
    return ret;
}

ll arr[1000+5],ans[1000+5];

bool comp(ll a,ll b)
{
    if(arr[a]<arr[b]) return true;
    else if(arr[a]==arr[b]) return a>b;
    return false;
}

int main()
{
    seive();
    ans[0]=0;
    for(ll i=1;i<=1000;i++)
        arr[i]=noOfDevisor(i),ans[i]=i;

    sort(ans+1,ans+1001,comp);

    ll testCase,caseNo=1,n;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        cout<<"Case "<<caseNo++<<": "<<ans[n]<<"\n";
    }
    return 0;
}
