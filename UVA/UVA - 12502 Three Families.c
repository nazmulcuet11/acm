#include <stdio.h>
#include <stdlib.h>

int main()
{
   int i,test,x,y,z;

   scanf("%d",&test);
   for(i=0;i<test;i++)
   {
       scanf("%d%d%d",&x,&y,&z);
       printf("%d\n",z*(x+x-y)/(x+y));
   }
    return 0;
}
