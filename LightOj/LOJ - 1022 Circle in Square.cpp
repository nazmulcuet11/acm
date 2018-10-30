#include <iostream>
#include <cstdio>
#include <cmath>

#define err 1e-9

using namespace std;

int main()
{
    int test_case,case_no=1;
    double rad,ans;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%lf",&rad);
        ans=(4*rad*rad)-2*acos(0)*rad*rad;
        printf("Case %d: %.2lf\n",case_no++,ans+err);
    }
    return 0;
}
