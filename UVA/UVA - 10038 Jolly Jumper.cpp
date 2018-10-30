#include<stdio.h>
#include<algorithm>
#include<stdlib.h>

using namespace std;

int main()
{
int n,flag,dif[3010],input[3010],i;

while(scanf("%d",&n)==1)
{
flag=1;

for(i=0;i<n;i++)
{
scanf("%d",&input[i]);
}

for(i=0;i<n-1;i++)
{
dif[i]=abs(input[i+1]-input[i]);
}

sort(dif,dif+i);///Here i = element number of dif[]

for(i=1;i<n-1;i++)
{
if((dif[i]-dif[i-1])!=1)
{
flag=0;
break;
}
}

if(flag==0)
printf("Not jolly\n");
else
printf("Jolly\n");

}
return 0;
}
