#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int i=1;
    char input[20];
    while(gets(input))
    {
        if(input[0]=='*')
        break;

        if(strcmp(input,"Hajj")==0)
        printf("Case %d: Hajj-e-Akbar\n",i);

        else
        printf("Case %d: Hajj-e-Asghar\n",i);

        i++;
    }
    return 0;
}
