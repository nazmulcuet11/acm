/**Bismillahir Rahmanir Rahim**/
/**
 *    @author     : Nazmul Islam
 *    @College    : CUET CSE 11
 *    @Topcoder   : nazmul_islam
 *    @CodeForces : nazmul_islam
 *    @UVA        : nazmul_cuet11
 *    @link       : https://www.facebook.com/nazmul.shohagh
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long          ll;
typedef unsigned long long llu;

#define ft        first
#define sd        second
#define mp        make_pair
#define pb(x)     push_back(x)
#define lcm(x,y)  x*y/__gcd(x,y)
#define all(x)    x.begin(),x.end()
#define allr(x)   x.rbegin(),x.rend()
#define mem(a,b)  memset(a,b,sizeof(a))
#define inf       1e9
#define eps       1e-9
#define mod       1000000007
#define NN        30100

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

ll test_case,row,col,a[1010][1010],dp[1010][1010];

struct node
{
    ll x,y,k;
    node(ll _x,ll _y, ll _k){x=_x;y=_y;k=_k;}
    bool operator <( const node& p ) const { return  p.k<k; }
};

void set_dp()
{
    for(ll i=0;i<1010;i++)
        for(ll j=0;j<1010;j++)
            dp[i][j]=inf;
}

ll dijkstra()
{
    priority_queue <node> pq;
    pq.push(node(0,0,a[0][0]));
    dp[0][0]=a[0][0];
    a[0][0]=-1;
    while(!pq.empty())
    {
        node temp=pq.top();pq.pop();
        ll x=temp.x;
        ll y=temp.y;
        ll k=temp.k;
        for(ll i=0;i<4;i++)
        {
            ll new_x=x+dir_x[i];
            ll new_y=y+dir_y[i];
            if(new_x>=0&&new_x<row&&new_y>=0&&new_y<col&&a[new_x][new_y]!=-1)
            {
                if(dp[new_x][new_y]>k+a[new_x][new_y])
                {
                    dp[new_x][new_y]=k+a[new_x][new_y];
                    pq.push(node(new_x,new_y,dp[new_x][new_y]));
                    a[x][y]=-1;
                }
            }
        }
    }
    return dp[row-1][col-1];
}

int main()
{
    for(scanf("%lld",&test_case);test_case;test_case--)
    {
        cin>>row>>col;
        for(ll i=0;i<row;i++)
            for(ll j=0;j<col;j++)
                cin>>a[i][j];
        set_dp();
        cout<<dijkstra()<<"\n";
    }
    return 0;
}
