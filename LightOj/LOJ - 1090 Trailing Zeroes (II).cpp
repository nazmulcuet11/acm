#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

#define SIZE_N 50000
#define MOD  1000000007

struct data{ll freq2,freq5;};

data trailingZeros(ll n)
{
    ll temp = n;
    data d;
    d.freq2=0;
    d.freq5=0;
    while(temp>0)
        d.freq2+=temp/2,temp/=2;
    temp = n;
    while(temp>0)
        d.freq5+=temp/5,temp/=5;
    return d;
}


ll solve(ll n,ll r,ll p,ll q)
{
    data a = trailingZeros(n);
    ll freq2 = 0,freq5 = 0;
    while(p%2==0)
        freq2++,p/=2;
    while(p%5==0)
        freq5++,p/=5;

    a.freq2+=freq2*q;
    a.freq5+=freq5*q;

    data b = trailingZeros(r);
    data c = trailingZeros(n-r);

    a.freq2-=(b.freq2+c.freq2);
    a.freq5-=(b.freq5+c.freq5);

    return min(a.freq2,a.freq5);
 }

int main()
{
    ll testCase,caseNo = 1,n,r,p,q;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>r>>p>>q;
        cout<<"Case "<<caseNo++<<": "<<solve(n,r,p,q)<<"\n";
    }
    return 0;
}
