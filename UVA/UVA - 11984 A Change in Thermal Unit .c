#include<stdio.h>

int main()
{
    int t;
    int c,d;
    float result;
    scanf("%d",&t);
    int i;
    for(i=1; i<=t; i++)
    {
        scanf("%d%d",&c,&d);
        result=(((9.00/5.00)*c+32.00+d)-32.00)*(5.00/9.00);
        printf("Case %d: %.2f\n",i,result);
    }
}
