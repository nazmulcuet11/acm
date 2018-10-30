#include<stdio.h>

int fibo(int n)
{
    if(n==0||n==1)
    return 1;

    else
    return fibo(n-2)+fibo(n-1);
}

int main()
{
    int result,n;
    while(scanf("%d",&n)==1)
    {
        if(n==0)
        break;

        result=fibo(n);
    printf("%d\n",result);
    }
return 0;
}
