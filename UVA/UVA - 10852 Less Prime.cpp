#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 100050

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

ll arr[256];

int main()
{
    //ios_base::sync_with_stdio(0); cin.tie(0);
    seive();
    ll testCase,caseno = 1,n,result,ans;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        result = 0;
        for(ll i=0;prime[i]<=n;i++)
        {
            ll temp =n/prime[i];
            if(result<n-temp*prime[i])
            {
                result=n-temp*prime[i];
                ans = prime[i];
            }
        }
        cout<<ans<<"\n";
    }
    return 0;
}

