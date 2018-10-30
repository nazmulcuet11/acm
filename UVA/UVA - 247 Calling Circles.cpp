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

//#define mp        make_pair
#define pb(x)     push_back(x)
#define lcm(x,y)  x*y/__gcd(x,y)
#define all(x)    x.begin(),x.end()
#define MAX(a)    (*max_element(all(a)))
#define MIN(a)    (*min_element(all(a)))
#define mem(a,b)  memset(a,b,sizeof(a))

#define inf       1e9
#define eps       1e-9
#define mod       1000000007
#define SIZE_N    100000+50

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

bool check_bit(ll n,ll i){return (1<<i)&n;}
ll set_bit(ll n,ll i){return (1<<i|n);}
ll reset_bit(ll n,ll i){return (0<<i&n);}

ll testCase,caseNo = 1,m,n,mat[30][30],node_no;
string u,v;
map<string,ll> mp;
map<ll,string> mp2;
bool visited[30];

int main()
{
	//ios_base::sync_with_stdio(0),cin.tie(0);
	while(cin>>n>>m&&(m||n))
    {
        mem(mat,0);
        node_no = 1;
        for(ll i=0;i<m;i++)
        {
            cin>>u>>v;
            if(!mp[u])
                mp2[node_no] = u,mp[u] = node_no++;
            if(!mp[v])
                mp2[node_no] = v,mp[v] = node_no++;
            mat[mp[u]][mp[v]] = 1;
        }

        for(ll k=1;k<node_no;k++)
            for(ll i=1;i<node_no;i++)
                for(ll j=1;j<node_no;j++)
                    if(mat[i][k]&&mat[k][j])
                        mat[i][j] = 1;

        if(caseNo>1) cout<<"\n";
        cout<<"Calling circles for data set "<<caseNo++<<":\n";

        mem(visited,false);
        for(ll i=1;i<node_no;i++)
        {
            if(visited[i]) continue;

            visited[i] = true;
            cout<<mp2[i];
            for(ll j=1;j<node_no;j++)
            {
                if(visited[j]) continue;

                if(mat[i][j]&&mat[j][i])
                {
                    visited[j] = true;
                    cout<<", "<<mp2[j];
                }
            }
            cout<<"\n";
        }

        mp.clear();
        mp2.clear();

    }
    return 0;
}
