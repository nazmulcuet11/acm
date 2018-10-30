#include<stdio.h>

int main()
{
int n,i,k,j=1;
while(scanf("%d",&n)==1)
{
    if(n==0)
    break;

    else
    {
for(i=4;;i++)
{
   k=(i*(i-3))/2;
   if(k>=n)
   break;
}
printf("Case %d: %d\n",j,i);
j++;
}
}
return 0;
}
