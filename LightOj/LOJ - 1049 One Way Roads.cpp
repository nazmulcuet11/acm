#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define inf 1e9

ll testCase,caseNo = 1,P,I;
ll pi[55],ice[55];
bool visited[55][55];
double mat[55][55];

double solve(ll i,ll j)
{
    if(i>=P||j>=I) return 0.00;

    double ret1 = 0.00,ret2 = 0.00,ret3 = 0.00,ret4 = 0.00;

    if(mat[i][j]!=-1)
    {
        ll val =  min(pi[i],ice[j]);
        pi[i] -= val;
        ice[j] -= val;
        ret1 = mat[i][j]*val+solve(i,j+1);
        ret2 = mat[i][j]*val+solve(i+1,j);
        pi[i] += val;
        ice[j] += val;
    }

    ret3 = solve(i,j+1);
    ret4 = solve(i+1,j);

    return max(max(ret1,ret2),max(ret3,ret4));
}

int main()
{
    while(cin>>P>>I&&(P||I))
    {
        for(ll i=0; i<P; i++)
            cin>>pi[i];
        for(ll i=0; i<I; i++)
            cin>>ice[i];

        for(ll i=0; i<P; i++)
            for(ll j=0; j<I; j++)
                cin>>mat[i][j];

        cout<<solve(0,0)<<"\n";
    }
    return 0;
}

