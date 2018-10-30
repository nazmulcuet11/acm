#include <stdio.h>

int f91(int n)
{
    if(n>100)
    return (n-10);

    else if(n<=100)
    {
      return f91(f91(n+11));
    }

}
int main()
{
    int n,result;
    while(scanf("%d",&n)==1)
    {
        if(n==0)
        break;

        else
        {
        result=f91(n);
        printf("f91(%d) = %d\n",n,result);
        }
    }
    return 0;
}
