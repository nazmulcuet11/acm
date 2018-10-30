#include<stdio.h>
int main()
{
int a,b,c,s,i,j;
while (scanf("%d",&c)==1)
{
for(i=1;i<=c;i++)
{
scanf("%d %d",&a,&b);
s=0;
if(a%2==0)
a=a+1;
for(j=a;j<=b;j=j+2)
s+=j;
printf("Case %d: %d\n",i,s);
}
}
return (0);
}