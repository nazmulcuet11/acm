#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define inf 999999999

struct edge
{
    ll u,v,cost;
};
edge edg[2000+50];

bool hasNegativeCycle(ll n,ll m)
{
    ll cst[1000+50];
    cst[0] = 0;
    for(ll i=1; i<n; i++) cst[i] = 1e9;

    for(ll i=0; i<n-1; i++)
        for(ll j=0; j<m; j++)
            if(cst[edg[j].v]>cst[edg[j].u]+edg[j].cost)
                cst[edg[j].v]=cst[edg[j].u]+edg[j].cost;

    for(ll j=0; j<m; j++)
            if(cst[edg[j].v]>cst[edg[j].u]+edg[j].cost)
                return true;

    return false;
}

int main()
{
    ll testCase,caseNo = 1,n,m,u,v,cst;
    cin>>testCase;
    while(testCase--)
    {
        cin>>n>>m;
        for(ll i=0; i<m; i++)
            cin>>edg[i].u>>edg[i].v>>edg[i].cost;
        if(hasNegativeCycle(n,m))
            cout<<"possible\n";
        else
            cout<<"not possible\n";
    }
    return 0;
}
