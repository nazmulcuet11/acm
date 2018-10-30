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

#define SIZE_N 1000005

double arr[SIZE_N];

int main()
{
    for(ll i=1; i<SIZE_N; i++)
        arr[i]=arr[i-1]+log10(i);
    ll testCase,caseNo=1,x,b;
    cin>>testCase;
    while(testCase--)
    {
        cin>>x>>b;
        cout<<"Case "<<caseNo++<<": ";
        if(x==0) cout<<"1\n";
        else
        {
            double ans = arr[x]/log10(b);
            ll r = (ll)(ans);
            cout<<r+1<<"\n";
        }
    }
    return 0;
}
