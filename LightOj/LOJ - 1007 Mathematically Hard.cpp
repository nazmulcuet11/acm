#include <iostream>
#include <cmath>
#include <cstring>
#include <vector>
#include <cstdio>
#include <ctime>

typedef unsigned long long int ULL;

using namespace std;

ULL ans[5000000+5]={0};
bool flag[5000000+5];

void phi(long long int N)
{
    for(ULL i=2; i<=N; i++)
    {
        if(flag[i])
        {
            for(ULL j=i; j<=N; j+=i)
            {
                flag[j]=false;
                if(ans[j]==0) ans[j]=j;
                ans [j]*=(i-1);
                ans [j]/=i;
            }
        }
        ans[i]=ans[i]*ans[i]+ans[i-1];
    }
}

int main()
{
    memset(flag,true,sizeof flag);
    phi(5000001);

    long long int test_case,case_no=1;
    ULL a,b;

    for(scanf("%lld",&test_case); test_case; test_case--)
    {
        scanf("%llu %llu",&a,&b);
        printf("Case %lld: %llu\n",case_no++,ans[b]-ans[a-1]);
    }
    return 0;
}
