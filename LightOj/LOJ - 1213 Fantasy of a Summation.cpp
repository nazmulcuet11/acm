#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

ll MOD;

ll power(ll b,ll p)
{
    if(p==0) return 1;
    if(p%2==0)
    {
        ll ret = power(b,p/2);
        return ((ret%MOD)*(ret%MOD))%MOD;
    }
    else
        return ((b%MOD)*(power(b,p-1)%MOD))%MOD;
}

int main()
{
    ll testCase,caseNo = 1,n,k,x;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>k>>MOD;
        ll temp = power(n,k-1);

        ll sum = 0;
        for(ll i=0;i<n;i++)
            cin>>x,sum=(sum+(temp*(x%MOD)*(k%MOD))%MOD)%MOD;

        cout<<"Case "<<caseNo++<<": "<<sum<<"\n";
    }
    return 0;
}
