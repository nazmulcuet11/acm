#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define MOD 1000
#define eps 1e-9

ll power(ll b,ll p)
{
    if(p==0) return 1;
    if(p%2==0)
    {
        ll ret = power(b,p/2)%MOD;
        return (ret*ret)%MOD;
    }
    else
        return (b%MOD*power(b,p-1)%MOD)%MOD;
}

int main()
{
    ll testCase,caseNo = 1,n,k;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>k;
        double temp = k*log10(n);
        temp-=(floor(temp)-2.00);
        temp = pow(10.00,temp)+eps;
        ll first = (ll)(temp);
        ll last = power(n%MOD,k);
        cout<<"Case "<<caseNo++<<": "<<first<<" ";
        if(last>=0&&last<=9)cout<<"00";
        else if(last>=10&&last<=99)cout<<"0";
        cout<<last<<"\n";
    }
    return 0;
}
