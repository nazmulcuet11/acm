#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 10000005

bool ok[SIZE_N];
vector <ll> prime;

ll freq[10000005];

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


ll factorize(ll n)
{
    ll ans = -1,temp = n,totalFactor = 0;
    for(ll i=0; prime[i]<=sqrt(n); i++)
    {
        if(n%prime[i]==0)
        {
            while(n%prime[i]==0)
                n/=prime[i];
            ans=max(ans,prime[i]);
            totalFactor++;
        }
    }
    if(n>1)
        ans=max(ans,n),totalFactor++;
    if(totalFactor==1) return -1;
    return ans;
}

int main()
{
    seive();
    //freopen("input.txt","r",stdin);
    ll testCase,caseno = 1,n,result,ans;
    while(cin>>n&&n)
    {
        cout<<factorize(fabs(n))<<"\n";
    }
    return 0;
}
