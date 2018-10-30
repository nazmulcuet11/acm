#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main()
{
    ll testCase,caseNo = 1,n;

    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        ll ans=0;
        for(ll i=2; i<=sqrt(n); i++)
        {
            ll x=(n/i);
            ans+=(x-i+1)*i;
            ans+=(x*(x+1))/2 - (i*(i+1))/2;
        }
        cout<<"Case "<<caseNo++<<": "<<ans<<"\n";
    }
    return 0;
}
