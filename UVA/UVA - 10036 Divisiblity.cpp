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
#define SIZE        30100

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

bool check_bit(ll n,ll i){return (1<<i)&n;}
ll set_bit(ll n,ll i){return (1<<i|n);}
ll reset_bit(ll n,ll i){return (0<<i&n);}

ll testCase,caseNo = 1,n,k,arr[10000+5],dp[10005][105];

bool solve(ll i,ll sum)
{
    if(i==n)
    {
        return sum%k==0;
    }

    if(dp[i][sum]!=-1) return dp[i][sum];

    bool ret1 = solve(i+1,(sum+arr[i]+k)%k);
    bool ret2 = solve(i+1,(sum-arr[i]+k)%k);

    return dp[i][sum]=ret1|ret2;
}

int main()
{
	//ios_base::sync_with_stdio(0),cin.tie(0);
	cin>>testCase;
	while(testCase--)
    {
        cin>>n>>k;
        for(ll i=0;i<n;i++)
            cin>>arr[i];

        mem(dp,-1);
        if(solve(0,0))
            cout<<"Divisible\n";
        else
            cout<<"Not divisible\n";
    }
    return 0;
}

