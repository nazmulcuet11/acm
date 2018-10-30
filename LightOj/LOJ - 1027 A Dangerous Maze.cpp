#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll testCase,caseNo = 1,n,x;

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>n;

        ll cnt = 0,sum = 0;

        for(ll i=0;i<n;i++)
        {
            cin>>x;
            if(x>=0)
                cnt++;
            sum+=fabs(x);
        }

        ll gcd = __gcd(cnt,sum);
        cout<<"Case "<<caseNo++<<": ";
        if(cnt==0)
            cout<<"inf\n";
        else
            cout<<sum/gcd<<"/"<<cnt/gcd<<"\n";
    }
}
