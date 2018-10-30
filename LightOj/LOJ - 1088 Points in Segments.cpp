#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long int> v;

int main()
{
    int test_case,case_no=1,N,Q;
    long long int x,A,B;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        v.clear();
        for(scanf("%d %d",&N,&Q);N;N--)
        {
            scanf("%lld",&x);
            v.push_back(x);
        }
        printf("Case %d:\n",case_no++);
        while(Q--)
        {
            scanf("%lld %lld",&A,&B);
            //vector<long long int>::iterator it;
            //it=lower_bound(v.begin(),v.end(),A);
            //it=v.begin();
            A=lower_bound(v.begin(),v.end(),A)-v.begin();
            B=upper_bound(v.begin(),v.end(),B)-v.begin();
            printf("%lld\n",B-A);
        }
    }
}
