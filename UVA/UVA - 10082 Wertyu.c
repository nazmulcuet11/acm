#include <stdio.h>
#include <string.h>

int main()
{
    char input[]={"1234567890-=WERTYUIOP[]\\SDFGHJKL;'XCVBNM,./ "};
    char output []={"`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,. "};
    char str[100000];
    long long int i, j;
    while(scanf("%c", &str[0])==1)
    {
        for(i=1; ; i++)
        {
            scanf("%c", &str[i]);
            if(str[i]=='\n')
            {
            break;
            }
        }

        for(i=0; i<strlen(str) ; i++)
        {    for(j=0; j<44 ; j++)
            {
                if(str[i]==input[j])
                printf("%c", output[j]);
            }
        }printf("\n");
    }
}
