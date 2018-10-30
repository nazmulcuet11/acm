#include<stdio.h>
#include<math.h>
#define abs(d) if(d<0) d=0; else d=d;

int main()
{
    int a,b,c,t;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d%d%d",&a,&b,&c);
        int d=ceil((a+b)/(c-1.00))-1;
        abs(d);
        printf("%d\n",d);
    }
    return 0;
}
