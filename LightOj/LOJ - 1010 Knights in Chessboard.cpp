#include <iostream>
#include <cstdio>
#define abs(a) if(a<0)-a; else a;

using namespace std;

int solution(int m,int n)
{
    if(m==1||n==1) return m*n;
    if(m==2||n==2)
    {
        int temp = m==2?n:m;
        int remainder = temp%4;
        temp /= 4;
        temp *= 4;
        return temp+(remainder>1?2:remainder)*2;
    }
    return m*n%2==0?m*n/2:m*n/2+1;
}

int main()
{
    int test_case,case_no=1,m,n;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d %d",&m,&n);
        printf("Case %d: %d\n",case_no++,solution(m,n));
    }
    return 0;
}
