#include <bits/stdc++.h>
 
using namespace std;
typedef long long ll;
 
ll testCase,caseNo = 1,n;
 
string strt,en,st1,st2,st3;
 
map<string,int> invalid;
 
int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>strt>>en;
        cin>>n;
        for(ll i=0; i<n; i++)
        {
            cin>>st1>>st2>>st3;
            for(ll j=0; j<st1.size(); j++)
                for(ll k=0; k<st2.size(); k++)
                    for(ll l=0; l<st3.size(); l++)
                    {
                        string str = "";
                        str.push_back(st1[j]);
                        str.push_back(st2[k]);
                        str.push_back(st3[l]);
                        invalid[str] = 1;
                    }
        }
 
 
        ll ans = -1;
        if(!invalid[en]&&!invalid[strt])
        {
            ans = 0;
            for(ll i=0; i<strt.size(); i++)
            {
                ll diff = fabs(strt[i]-en[i]);
                if(diff>13)
                    diff = 26-diff;
                ans+=diff;
            }
        }
 
        cout<<"Case "<<caseNo++<<": "<<ans<<"\n";
 
        invalid.clear();
    }
    return 0;
}