#include <stdio.h>

int main()
{
    long long int input;
    int mod,i,bin[50000];
    while(scanf("%lld",&input)==1)
    {
        mod=0;
        i=0;

        if(input==0)
            break;

        else
        {
            while(input!=0)
            {
                bin[i]=input%2;
                input=input/2;
                i++;

            }

            printf("The parity of ");
            while(i>0)
            {
                printf("%d",bin[i-1]);

                if(bin[i-1]==1)
                    mod++;

                i--;
            }
            printf(" is %d (mod 2).",mod);
        }
        printf("\n");
    }
    return 0;
}
