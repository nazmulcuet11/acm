#include <stdio.h>

int main()
{
    int t,i,a,b,x,y;
    scanf("%d",&t);
    for(i=0; i<t; i++)
    {
        scanf("%d%d",&a,&b);
        if(a>=b&&(a+b)%2==0)
        {
            x=(a+b)/2;
            y=(a-b)/2;
            printf("%d %d\n",x,y);
        }
        else
            printf("impossible\n");
    }
    return 0;
}
