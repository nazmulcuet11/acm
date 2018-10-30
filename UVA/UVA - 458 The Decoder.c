#include<stdio.h>
#include<string.h>

int main()
{
    int i,j,k,n;

    char a[500];
    char b;

    while(gets(a))
    {
        n=strlen(a);

        for(i=0; i<n; i++)
        {
            j=a[i];
            b=j-7;
            printf("%c",b);
        }
        printf("\n");
    }
    return 0;
}
