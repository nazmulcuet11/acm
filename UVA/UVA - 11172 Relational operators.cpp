#include<stdio.h>

int main()
{
int t;
while(scanf("%d",&t)==1)
{
int i;
for(i=0;i<t;i++)
{
int a,b;
scanf("%d%d",&a,&b);
if(a>b)
printf(">\n");
else if(a<b)
printf("<\n");
else
printf("=\n");
}
}
return 0;
}