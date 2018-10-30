#include <iostream>
#include <cstdio>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    long long int test_case,case_no=1,P,L;
    for(scanf("%lld",&test_case); test_case; test_case--)
    {
        scanf("%lld %lld",&P,&L);
        P-=L;
        vector<long long int> v;
        if(L<P)
        {
            for(long long int i=1; i<sqrt(P)+1; i++)
            {
                if(P%i==0)
                {
                    v.push_back(i);
                    v.push_back(P/i);
                }
            }
            sort(v.begin(),v.end());
            printf("Case %lld:",case_no++);
            long long int prev=-1;
            for(int i=0;i<v.size();i++)
                if(v[i]>L&&prev!=v[i])
                {
                    printf(" %lld",v[i]);
                    prev=v[i];
                }

            printf("\n");
        }
        else
        printf("Case %lld: impossible\n",case_no++);
    }
    return 0;
}
