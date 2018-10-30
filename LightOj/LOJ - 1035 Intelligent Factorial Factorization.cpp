#include<bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE_N 105

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

void solve(ll n)
{
    bool first = true;
    for(ll i=0; prime[i]<=n; i++)
    {
        ll temp = n,freq = 0;
        while(temp>0)
            freq+=temp/prime[i],temp/=prime[i];

        if(freq>0)
        {

            if(!first) cout<<" * ";
            cout<<prime[i]<<" ("<<freq<<")";
            first = false;
        }
    }
    cout<<"\n";
}

main()
{
    seive();
    ll n,tc,i,j,k;
    cin>>tc;
    for(k=1; k<=tc; k++)
    {
        cin>>n;
        cout<<"Case "<<k<<": "<<n<<" = ";
        solve(n);
    }
    return 0;

}
