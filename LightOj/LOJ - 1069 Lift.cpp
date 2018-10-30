#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    int test_case,case_no=1,My_pos,Lift_pos;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d %d",&My_pos,&Lift_pos);
        Lift_pos=Lift_pos<My_pos?(2*My_pos-Lift_pos):Lift_pos;
        printf("Case %d: %d\n",case_no++,Lift_pos*4+19);
    }
    return 0;
}
