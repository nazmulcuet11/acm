#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main()
{
    int test_case,case_no=1;
    long long int a[3];
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%lld %lld %lld",&a[0],&a[1],&a[2]);
        sort(a,a+3);
        if(a[0]*a[0]+a[1]*a[1]==a[2]*a[2])
            printf("Case %d: yes\n",case_no++);
        else
            printf("Case %d: no\n",case_no++);
    }
    return 0;
}
