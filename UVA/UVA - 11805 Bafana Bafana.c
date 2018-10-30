#include<stdio.h>
int main()
{
int t,a,b,c,i,k,temp;
scanf("%d",&t);
for(i=1;i<=t;i++)
{
scanf("%d%d%d",&a,&b,&c);
int n[a+1];
for(k=1;k<=a;k++)
{
n[k]=k;
}

temp=b+c;

while(temp>a)
{
temp=temp-a;
}

printf("Case %d: %d\n",i,n[temp]);
}
}
