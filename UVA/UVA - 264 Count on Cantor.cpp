#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 10000050

ll N[SIZE],D[SIZE];

int main()
{
    //For Numerator
    ll cnt = 0, k = 1;
    while(cnt<SIZE)
    {
        for(ll i=1;i<=k&&cnt<SIZE;i++)
            N[cnt] = i,cnt++;
        for(ll i=k-1;i>=1&&cnt<SIZE;i--)
            N[cnt] = i,cnt++;
        k+=2;
    }
    //For Denominator
    cnt = 0;
    k = 2;
    while(cnt<SIZE)
    {
        for(ll i=1;i<=k&&cnt<SIZE;i++)
            D[cnt] = i,cnt++;
        for(ll i=k-1;i>=1&&cnt<SIZE;i--)
            D[cnt] = i,cnt++;
        k+=2;
    }

    ll n;
    bool first = true;
    while(cin>>n)
    {
        //if(!first) cout<<"\n";
        cout<<"TERM "<<n<<" IS "<<N[n-1]<<"/"<<D[n-1]<<"\n";
        first = false;
    }

    return 0;
}
