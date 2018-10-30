#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(long long int a,long long int b){return a>b;}

int main()
{
    int t,case_no=1;
    for( scanf("%d",&t);t;t--)
    {
        long long int n,w,x,y,ans=0,brush_now;
        vector<long long int> v;
        for(scanf("%lld %lld",&n,&w);n;n--)
        {
            scanf("%lld %lld",&x,&y);
            v.push_back(y);
        }
        sort(v.begin(),v.end(),comp);
        while(!v.empty())
        {
            brush_now=v.back();
            v.pop_back();
            ans++;
            while(!v.empty()&&v.back()<=brush_now+w)
                v.pop_back();
        }
        printf("Case %d: %lld\n",case_no++,ans);
    }
    return 0;
}
