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
//#define mp        make_pair
#define pb(x)     push_back(x)
#define lcm(x,y)  x*y/__gcd(x,y)
#define all(x)    x.begin(),x.end()
#define allr(x)   x.rbegin(),x.rend()
#define MAX(a)    (*max_element(all(a)))
#define MIN(a)    (*min_element(all(a)))
#define mem(a,b)  memset(a,b,sizeof(a))
#define inf       1e9
#define eps       1e-9
#define mod       1000000007
#define NN        30100

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

bool check_bit(ll n,ll i){return (1<<i)&n;}
ll set_bit(ll n,ll i){return (1<<i|n);}
ll reset_bit(ll n,ll i){return (0<<i&n);}

ll testCase,caseNo = 1,m,n,q,total = 0,cnt[500+5][500+5];
bool visited[500+5][500+5];
char mp[500+5][500+5];

void mark(ll i,ll j)
{
    if(i<=0||j<=0||i>m||j>n) return;
    if(mp[i][j]=='#'||visited[i][j]) return;

    visited[i][j] = true;
    cnt[i][j] = total;
    for(ll pos=0;pos<4;pos++)
        mark(i+dir_x[pos],j+dir_y[pos]);
}

void dfs(ll i,ll j)
{
    if(i<=0||j<=0||i>m||j>n) return;
    if(mp[i][j]=='#'||visited[i][j]) return;

    visited[i][j] = true;
    if(mp[i][j]=='C')
        total++;
    for(ll pos=0;pos<4;pos++)
        dfs(i+dir_x[pos],j+dir_y[pos]);
}


int main()
{
	//ios_base::sync_with_stdio(0),cin.tie(0);
	cin>>testCase;
	while(testCase--)
    {
        cin>>m>>n>>q;
        for(ll i=1;i<=m;i++)
            for(ll j=1;j<=n;j++)
                cin>>mp[i][j];

        mem(cnt,-1);
        cout<<"Case "<<caseNo++<<":\n";
        for(ll i=0;i<q;i++)
        {
            ll x,y;
            cin>>x>>y;

            if(cnt[x][y]==-1)
            {
                total=0;
                mem(visited,false);
                dfs(x,y);
                mem(visited,false);
                mark(x,y);
            }
            cout<<cnt[x][y]<<"\n";
        }
    }
    return 0;
}
