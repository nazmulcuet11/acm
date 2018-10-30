#include <stdio.h>
#include <math.h>

int main()
{
   long int n,root;
    while(scanf("%ld",&n)==1)
    {
        if(n==0)
        break;

        root=sqrt(n);

        if(n==(root*root))
        printf("yes\n");

        else
        printf("no\n");
    }
    return 0;
}
