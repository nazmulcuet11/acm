#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    int testcase,a,b,c,i=1;
    scanf("%d",&testcase);

    while(testcase--)
    {
      scanf("%d%d%d",&a,&b,&c);

      if(a<=20&&b<=20&&c<=20)
      printf("Case %d: good\n",i);

      else
      printf("Case %d: bad\n",i);

      i++;

    }
    return 0;
}
