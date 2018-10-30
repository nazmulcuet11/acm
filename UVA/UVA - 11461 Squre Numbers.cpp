#include<stdio.h>
#include<math.h>

int main()
{
int a,b;
while(scanf("%d%d",&a,&b)==2)
{
if(a==0&&b==0)
break;
else
{
	int i,j,k,n=0;
for(i=a;i<=b;i++)
{
j=sqrt(i);
k=j*j;
if(i==k)
{
n++;
}
}
printf("%d\n",n);
}
}
return 0;
}