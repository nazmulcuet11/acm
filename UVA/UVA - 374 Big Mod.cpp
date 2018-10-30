#include <iostream>
#define ll long long int
using namespace std;
ll big_mod(ll b,ll p,ll m)
{
    if(p==0)
        return 1;
    if(p%2==0)
        return ((big_mod(b,p/2,m)%m)*(big_mod(b,p/2,m)%m))%m;
    return ((big_mod(b,p-1,m)%m)*(b%m))%m;
}

int main()
{
    ll b,p,m;
    while(cin>>b>>p>>m)
    {
        cout<<big_mod(b,p,m)<<endl;
    }
    return 0;
}
