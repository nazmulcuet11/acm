#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main()
{
    //freopen("input.txt","r",stdin);
    ll testCase,caseNo = 1,n;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;
        ll sum = 0;
        ll sq = sqrt(n);

        for(ll i=1;i<=sq;i++)
        {
            ll x = n/i;
            ll y = n/(i+1);
            sum+=x;
            if(x!=i)
                sum=sum+i*(x-y);
        }

        cout<<"Case "<<caseNo++<<": "<<sum<<"\n";
    }
    return 0;
}
