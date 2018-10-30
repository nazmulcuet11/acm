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


struct data
{
    string name,os;
    ll val;
};

ll testCase,caseNo = 1,L,R,dp[1005][1005],cnt[1005][1005];

data lft[1000+5],rht[1000+5];

void solve()
{
    mem(dp,0);
    mem(cnt,0);

    for(ll i=1;i<=L;i++)
        for(ll j=1;j<=R;j++)
        {
            dp[i][j] = dp[i-1][j];
            cnt[i][j] = cnt[i-1][j];

            if(dp[i][j]<dp[i][j-1]||(dp[i][j]==dp[i][j-1]&&cnt[i][j]>cnt[i][j-1]))
            {
                dp[i][j] = dp[i][j-1];
                cnt[i][j] = cnt[i][j-1];
            }

            if(lft[i].os==rht[j].os)
            {
                if(dp[i][j]<dp[i-1][j-1]+lft[i].val+rht[j].val||
                   (dp[i][j]==dp[i-1][j-1]+lft[i].val+rht[j].val&&cnt[i][j]>cnt[i-1][j-1]+1))
                {
                    dp[i][j] = dp[i-1][j-1]+lft[i].val+rht[j].val;
                    cnt[i][j] = cnt[i-1][j-1]+1;
                }
            }
        }
}

int main()
{
	//ios_base::sync_with_stdio(0),cin.tie(0);
    cin>>testCase;
    while(testCase--)
    {
        cin>>L;
        for(ll i=1;i<=L;i++)
            cin>>lft[i].name>>lft[i].os>>lft[i].val;
        cin>>R;
        for(ll i=1;i<=R;i++)
            cin>>rht[i].name>>rht[i].os>>rht[i].val;

        solve();
        cout<<dp[L][R]<<" "<<cnt[L][R]<<"\n";
    }
    return 0;
}
